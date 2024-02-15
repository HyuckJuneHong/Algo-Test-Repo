package src.문제_풀이_전략._10_구현_DFS_BFS;

/**
 numbers[] : 사용할 수 있는 숫자가 담긴 배열 (len=2~20, val=1~50)
 target : 타겟 넘버 (1~1_000)
 return int : 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법 수

 1. DFS 완전 탐색으로 풀면 될 듯
 */
public class Lv2_타겟_넘버_DFS {

	public int solution(int[] numbers, int target) {
		return dfs(numbers, target, 0, 0);
	}

	private int dfs(int[] numbers, int target, int depth, int sum) {
		if (depth == numbers.length) {
			if (sum == target) {
				return 1;
			}

			return 0;
		}

		int result1 = dfs(numbers, target, depth + 1, sum + numbers[depth]);
		int result2 = dfs(numbers, target, depth + 1, sum - numbers[depth]);

		return result1 + result2;
	}
}
