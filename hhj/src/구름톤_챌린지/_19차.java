package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 문제
 - 번호가 붙은 N개의 도시
 - M개의 도로 (양방향)
 - 플레이어는 S번 도시에서 E번 도시로 이동
 - 항상 가장 작은 수의 도시를 거쳐 경로 이동
 - i일 뒤에 i번 도시는 하루 동안 공사 예정
 - N일 동안 이동 시, 도시 수 출력

 입력
 - N : 도시 수 (3~1_000)
 - M : 도로 수 (N-1 ~ 2_000)
 - S : 출발 도시 (1 ~ N)
 - E : 도착 도시 (1 ~ N)
 */
public class _19차 {

	static List<List<Integer>> graph = new ArrayList<>();
	static List<Integer> answer = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int S = Integer.parseInt(input[2]);
		int E = Integer.parseInt(input[3]);
		int[][] cities = new int[M][2];

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			cities[i][0] = Integer.parseInt(input[0]);
			cities[i][1] = Integer.parseInt(input[1]);
		}

		init(N, cities);

		for (int i = 1; i <= N; i++) {
			answer.add(bfs(i, N, M, S, E, cities));
		}

		for (int a : answer) {
			System.out.println(a);
		}
	}

	private static int bfs(int day, int N, int M, int S, int E, int[][] cities) {
		Deque<Integer> q = new ArrayDeque<>();
		int[] dis = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		visited[S] = true;
		dis[S] = 1;
		q.add(S);

		if (day == S) {
			return -1;
		}

		while (!q.isEmpty()) {
			int s = q.poll();

			for (int e : graph.get(s)) {
				if (day != e && !visited[e] && dis[e] > dis[s] + 1) {
					q.add(e);
					visited[e] = true;
					dis[e] = dis[s] + 1;

					if (e == E) {
						return dis[e];
					}
				}
			}
		}

		return -1;
	}

	private static void init(int N, int[][] cities) {
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] city : cities) {
			int a = city[0];
			int b = city[1];
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
	}
}
