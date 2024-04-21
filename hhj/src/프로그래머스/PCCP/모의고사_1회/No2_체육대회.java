package src.프로그래머스.PCCP.모의고사_1회;

public class No2_체육대회 {
	/**
	 - 각 반의 해당 종목 대표가 1명씩 나와 대결
	 - 한 학생은 최대 1개의 종목 대표만 할 수 있음
	 - 반에서 한 종목당 1명의 대표 뽑으려 함. (학생의 능력은 수치화되어 있음)
	 - 우리반 전략은 각 종목 대표의 해당 종목에 대한 능력치의 합을 최대화하는 것.

	 int[][] ability : 반 학생들의 각 종목에 대한 능력치
	 - ability[i] = i 학생의 각 능력치
	 - ability[i][j] = i 학생의 j 종목 능력치 (0~10_000)
	 return int : 선발된 대표들의 해당 종목에 대한 능력치 합
	 */
	int answer = 0;

	public int solution(int[][] ability) {
		int n = ability.length;       // 학생 수(1~10)
		int m = ability[0].length;    // 종목 수(1~10)

		dfs(ability, n, m, 0, 0, new boolean[n]);

		return answer;
	}

	private void dfs(int[][] ability, int n, int m, int depth, int sum, boolean[] visited) {
		if (depth == m) {
			answer = Math.max(answer, sum);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			dfs(ability, n, m, depth + 1, sum + ability[i][depth], visited);
			visited[i] = false;
		}
	}
}
