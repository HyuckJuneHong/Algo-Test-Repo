package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 문제
 - 바다 위 N개 섬
 - 섬은 1번부터 N번까지 번호 붙음
 - 서로 다른 두 섬 연결하는 M개의 다리
 - 단방향으로만 이동 가능
 - 어떤 두 섬 사이 잇는 다리는 정방향 하나, 역방향 하나 (최대 2개)
 - 임의 두 섬 a, b에 대해 a에서 b로 직접 이동 다리와 b에서 a로 직접 이동 다리 있으면 두 섬 연합 결성
 - 이때, a, b / b, c이면 a, c도 연합 결성 (조건 만족 안해도)
 - 연합이 없어도 자기 자신은 연합 1개
 - N개의 섬 사이에 존재하는 연합 개수 구하기

 입력
 - N : 섬 개수(2~2_000)
 - M : 다리 개수(1~200_000)
 */
public class _16일차 {
	static int[][] graph;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[][] island = new int[M][2];

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			island[i][0] = Integer.parseInt(input[0]);
			island[i][1] = Integer.parseInt(input[1]);
		}

		int answer = countTeam(N, M, island);
		System.out.print(answer);
	}

	private static int countTeam(int N, int M, int[][] island) {
		int count = 0;
		init(N, M, island);

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				bfs(N, i);
				count += 1;
			}
		}

		return count;
	}

	private static void bfs(int N, int a) {
		Deque<Integer> q = new ArrayDeque<>();
		q.add(a);

		while (!q.isEmpty()) {
			int start = q.poll();
			visited[start] = true;

			for (int end = 1; end <= N; end++) {
				if (!visited[end] && graph[start][end] == 1 && graph[end][start] == 1) {
					q.add(end);
				}
			}
		}
	}

	private static void init(int N, int M, int[][] island) {
		graph = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int a = island[i][0];
			int b = island[i][1];
			graph[a][b] = 1;
		}
	}
}
