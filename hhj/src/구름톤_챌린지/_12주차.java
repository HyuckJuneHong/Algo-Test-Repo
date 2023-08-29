package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 문제
 - 한 변의 길이가 N인 정사각형 모양의 마을 M을 만듬
 - r번째 행, c번째 열에 해당하는 칸 Mrc가 적힘
 - Mrc는 0 또는 1 중 하나
 - 0 : 아무것도 없는 칸
 - 1 : 집이 있는 칸
 - 전력 공급을 위해 발전기를 설치하거나 상하좌우로 인접한 집 중 하나가 전력을 공급받고 있으면 됨
 - 발전기의 최소 개수는?

 입력
 - N : 마을의 크기 (1~1_000)
 - M : 마을의 상태 배열

 풀이
 - 1을 찾음
 - 1을 찾았을 때, 주변에 1이 있는 지 확인
 - 1이 있으면 제거하거나 패스
 - 1이 없으면 패스
 - 반복문 끝나면 최소와 비교
 */
public class _12주차 {

	static final int[] DX = {-1, 0, 1, 0};
	static final int[] DY = {0, 1, 0, -1};

	static int answer = 0;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] M = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");

			for (int j = 0; j < N; j++) {
				M[i][j] = Integer.parseInt(input[j]);
			}
		}

		installGenerator(N, M);
		System.out.print(answer);
	}

	private static void installGenerator(int N, int[][] M) {
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (M[i][j] == 1 && !visited[i][j]) {
					bfs(N, M, i, j);
					answer++;
				}
			}
		}
	}

	private static void bfs(int N, int[][] M, int i, int j) {
		Deque<Point> q = new ArrayDeque<>();
		q.add(new Point(i, j));
		visited[i][j] = true;

		while (!q.isEmpty()) {
			Point current = q.poll();
			int ni;
			int nj;

			for (int k = 0; k < 4; k++) {
				ni = current.i + DY[k];
				nj = current.j + DX[k];

				if (ni >= 0 && ni < N && nj >= 0 && nj < N && M[ni][nj] == 1 && !visited[ni][nj]) {
					q.add(new Point(ni, nj));
					visited[ni][nj] = true;
				}
			}
		}
	}

	static class Point {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
