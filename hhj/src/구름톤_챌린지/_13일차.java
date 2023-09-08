package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 문제
 - 한 변의 길이가 N인 정사각형 모양의 마을 M을 만들고 있음
 - 마을의 모든 칸에는 건물 하나씩 있음
 - r번째, c번째 행열 칸에는 정수 Mrc가 적힘
 - 건물의 유형 번호를 의미
 - 건물의 유형이 동일하면서 서로 상하좌우 인접한 칸에 위치한 건물끼리 서로 전력 공유 가능
 - 전력 공유 가능 관계에 속한 건물 개수가 K개 이상히면 이를 단지라고 함
 - 단지 당 하나의 발전기만 설치 가능
 - 발전기는 특정 건물 유형 하나에 해당하는 모든 단지 전력 공급 가능
 - 가장 많은 단지에 있는 건물 유형에 전력 공급할 것
 - 여러개면 Mrc가 더 큰 것에 공급
 - 플레이어가 공급할 유형 번호 구함

 입력
 - N : 마을 크기 (1~1_000)
 - K : 단지 기준 (1~50)
 - M : 마을(Mrc : 1~30)

 풀이
 1) 상하좌우 인접 배열 선언
 2) 단지 개수를 담을 Map 선언
 3) 방문 유무 배열 선언
 4) bfs 탐색
 */
public class _13일차 {
	static final int[] DX = {-1, 0, 1, 0};
	static final int[] DY = {0, 1, 0, -1};

	static Map<Integer, Integer> numbers;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int[][] M = new int[N][N];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");

			for (int j = 0; j < N; j++) {
				M[i][j] = Integer.parseInt(input[j]);
			}
		}

		int answer = getMaxGenerator(N, K, M);
		System.out.println(answer);
	}

	private static int getMaxGenerator(int N, int K, int[][] M) {
		numbers = new HashMap();
		visited = new boolean[N][N];
		int number = 0;
		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(N, K, M, i, j, M[i][j]);
				}
			}
		}

		for (int key : numbers.keySet()) {
			if (numbers.get(key) > max) {
				number = key;
				max = numbers.get(key);
				continue;
			}

			if (numbers.get(key) == max && key > number) {
				number = key;
			}
		}

		return number;
	}

	private static void bfs(int N, int K, int[][] M, int y, int x, int number) {
		int count = 0;
		Deque<Point> q = new ArrayDeque();
		q.add(new Point(y, x));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Point current = q.poll();
			count++;

			for (int i = 0; i < 4; i++) {
				int ny = current.y + DY[i];
				int nx = current.x + DX[i];

				if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx] && M[ny][nx] == number) {
					visited[ny][nx] = true;
					q.add(new Point(ny, nx));
				}
			}
		}

		if (count >= K) {
			numbers.put(number, numbers.getOrDefault(number, 0) + 1);
		}
	}

	public static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
