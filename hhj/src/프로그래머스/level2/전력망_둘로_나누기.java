package src.프로그래머스.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 전력망_둘로_나누기 {
	static int[][] graph;

	public int solution(int n, int[][] wires) {
		int answer = n;
		init(n, wires);

		for (int i = 0; i < wires.length; i++) {
			int a = wires[i][0];
			int b = wires[i][1];

			graph[a][b] = graph[b][a] = 0;
			answer = Math.min(answer, bfs(n, a));
			graph[a][b] = graph[b][a] = 1;
		}

		return answer;
	}

	private int bfs(int n, int start) {
		Deque<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n + 1];
		int count = 0;
		q.add(start);

		while (!q.isEmpty()) {
			start = q.poll();
			visited[start] = true;
			count++;

			for (int end = 1; end <= n; end++) {
				if (!visited[end] && graph[start][end] == 1) {
					q.add(end);
				}
			}
		}

		return Math.abs(count - (n - count));
	}

	private void init(int n, int[][] wires) {
		graph = new int[n + 1][n + 1];

		for (int i = 0; i < wires.length; i++) {
			int a = wires[i][0];
			int b = wires[i][1];
			graph[a][b] = graph[b][a] = 1;
		}
	}
}
