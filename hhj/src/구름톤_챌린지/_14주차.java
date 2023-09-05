package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _14주차 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int K = Integer.parseInt(input[2]);
		int[][] graph = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			graph[a][b] = graph[b][a] = 1;
		}

		int[] answer = bfs(N, K, graph);
		System.out.print(answer[0] + " " + answer[1]);
	}

	private static int[] bfs(int N, int K, int[][] graph) {
		Deque<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		int count = 1;
		int lastIndex = K;
		q.add(K);

		while (!q.isEmpty()) {
			int start = q.poll();
			int min = N;
			visited[start] = true;
			lastIndex = start;

			for (int end = 1; end <= N; end++) {
				if (!visited[end] && graph[start][end] == 1 && min >= end) {
					min = end;
					count++;
					q.add(end);
					visited[end] = true;
				}
			}
		}

		return new int[] {count, lastIndex};
	}
}
