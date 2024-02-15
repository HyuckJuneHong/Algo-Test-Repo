package src.문제_풀이_전략._4_완전탐색;

import java.util.HashSet;
import java.util.Set;

public class Lv2_소수_찾기 {

	static Set<Integer> answer = new HashSet<>();
	static boolean[] visited;

	public int solution(String numbers) {
		visited = new boolean[numbers.length()];
		dfs(numbers, "", 0);

		return answer.size();
	}

	private void dfs(String numbers, String current, int depth) {
		if (depth > numbers.length()) {
			return;
		}

		if (!current.isBlank() && isDecimal(Integer.parseInt(current))) {
			answer.add(Integer.parseInt(current));
		}

		for (int i = 0; i < numbers.length(); i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			dfs(numbers, current + numbers.charAt(i), depth + 1);
			visited[i] = false;
		}
	}

	private boolean isDecimal(int number) {
		if (number < 2) {
			return false;
		}

		int mid = (int)Math.sqrt(number);

		for (int i = 2; i <= mid; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}
}
