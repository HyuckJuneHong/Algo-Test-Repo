package src.문제_풀이_전략._5_정렬;

import java.util.HashSet;
import java.util.Set;

public class Lv1_두_개_뽑아서_더하기_월간코드챌린지 {

	static Set<Integer> answer = new HashSet<>();
	static boolean[] visited;

	public int[] solution(int[] numbers) {
		visited = new boolean[numbers.length];
		dfs(numbers, 0, 0);

		return answer.stream()
			.sorted()
			.mapToInt(Integer::intValue)
			.toArray();
	}

	public void dfs(int[] numbers, int depth, int sum) {
		if (depth == 2) {
			answer.add(sum);
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			dfs(numbers, depth + 1, sum + numbers[i]);
			visited[i] = false;
		}
	}
}
