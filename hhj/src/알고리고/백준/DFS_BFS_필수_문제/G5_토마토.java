package src.알고리고.백준.DFS_BFS_필수_문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class G5_토마토 {

	static Queue<Point> queue = new LinkedList<>();
	static int[][][] distance;
	static int[] dz = {-1, 0, 0, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0, 0, 0};
	static int[] dx = {0, 0, 0, -1, 1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input1 = br.readLine().split(" ");
		int m = Integer.parseInt(input1[0]); // 가로 수
		int n = Integer.parseInt(input1[1]); // 세로 수
		int h = Integer.parseInt(input1[2]); // 상자 수

		distance = new int[h][n][m];

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				String[] tomato = br.readLine().split(" ");

				for (int j = 0; j < m; j++) {
					distance[k][i][j] = Integer.parseInt(tomato[j]);

					if (distance[k][i][j] == 1) {
						queue.add(new Point(k, i, j));
					}
				}
			}
		}

		int answer = solution(h, n, m);

		System.out.println(answer);

		bw.flush();
		br.close();
		bw.close();
	}

	private static int solution(int h, int n, int m) {
		int result = bfs(h, n, m) - 1;

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (distance[k][i][j] == 0) {
						return -1;
					}
				}
			}
		}

		return result;
	}

	private static int bfs(int h, int n, int m) {
		int cz = 0;
		int cy = 0;
		int cx = 0;

		while (!queue.isEmpty()) {
			Point current = queue.poll();
			cz = current.z;
			cy = current.y;
			cx = current.x;

			for (int i = 0; i < 6; i++) {
				int nz = dz[i] + cz;
				int ny = dy[i] + cy;
				int nx = dx[i] + cx;

				if (nz == -1 || ny == -1 || nx == -1 || nz == h || ny == n || nx == m) {
					continue;
				}

				if (distance[nz][ny][nx] == 0) {
					queue.add(new Point(nz, ny, nx));
					distance[nz][ny][nx] = distance[cz][cy][cx] + 1;
				}
			}
		}

		return distance[cz][cy][cx];
	}

	private static class Point {

		int z;
		int y;
		int x;

		public Point(int z, int y, int x) {
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}
}
