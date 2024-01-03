package src.알고리고.문제_풀이_전략._9_그래프와_트리;

/**
 n : 선수의 수 (1~100)
 result : 경기 결과를 담은 2차원 배열(results[0]_len=1~4_500)
 return : 정확하게 순위를 매길 수 있는 선수

 1. results를 토대로 승리, 패배 방향 그래프를 만든다.
 2. 그래프에서 특정 노드로 올 수 있는 노드 수(승리 + 패배) == n - 1 이면 정확한 순위이다.
 */
public class Lv3_순위_그래프 {

	static int[][] graph;

	public int solution(int n, int[][] results) {
		int answer = 0;

		init(n, results);

		for (int start = 1; start <= n; start++) {
			int winner = dfs(n, new boolean[n + 1], start, 1, 0);
			int loser = dfs(n, new boolean[n + 1], start, -1, 0);

			if (winner + loser == n - 1) {
				answer += 1;
			}
		}

		return answer;
	}

	private int dfs(int n, boolean[] visited, int start, int winAndLose, int depth) {
		for (int end = 1; end <= n; end++) {
			if (visited[end] || start == end || graph[start][end] != winAndLose) {
				continue;
			}

			visited[end] = true;
			depth = dfs(n, visited, end, winAndLose, depth + 1);
		}

		return depth;
	}

	private void init(int n, int[][] results) {
		graph = new int[n + 1][n + 1];

		for (int i = 0; i < results.length; i++) {
			int start = results[i][0];
			int end = results[i][1];

			graph[start][end] = 1;
			graph[end][start] = -1;
		}
	}
}
