package src.알고리고.백준.삼성_SW_역량_테스트_기출_문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G4_14502_연구소 {

	static final int WALL = 3;
	static final int[] DX = {-1, 0, 1, 0};
	static final int[] DY = {0, 1, 0, -1};

	static String[] input;
	static int n;
	static int m;
	static int totalWall = 3;
	static int[][] board;
	static List<int[]> initVirus = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");

			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(input[j]);

				if (board[i][j] == 2) {
					initVirus.add(new int[] {i, j});
				} else if (board[i][j] == 1) {
					totalWall += 1;
				}
			}
		}

		dfs(0);
		System.out.println(n * m - (totalWall + answer));

		bw.flush();
		br.close();
		bw.close();
	}

	private static void dfs(int wall) {
		if (wall == WALL) {
			bfs();
			return;
		}

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (board[y][x] == 0) {
					board[y][x] = 1;
					dfs(wall + 1);
					board[y][x] = 0;
				}
			}
		}
	}

	private static void bfs() {
		int virusCount = initVirus.size();
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> virus = new LinkedList<>();

		for (int[] v : initVirus) {
			int y = v[0];
			int x = v[1];
			virus.add(new int[] {y, x});
		}

		while (!virus.isEmpty()) {
			int[] current = virus.poll();
			int y = current[0];
			int x = current[1];

			for (int i = 0; i < 4; i++) {
				int ny = DY[i] + y;
				int nx = DX[i] + x;

				if (ny == -1 || nx == -1 || ny == n || nx == m || board[ny][nx] != 0 || visited[ny][nx]) {
					continue;
				}

				visited[ny][nx] = true;
				virus.add(new int[] {ny, nx});
				virusCount += 1;
			}
		}

		answer = Math.min(answer, virusCount);
	}
}
