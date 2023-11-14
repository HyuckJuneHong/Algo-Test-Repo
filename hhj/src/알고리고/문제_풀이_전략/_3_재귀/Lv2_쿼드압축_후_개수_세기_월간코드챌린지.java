package src.알고리고.문제_풀이_전략._3_재귀;

public class Lv2_쿼드압축_후_개수_세기_월간코드챌린지 {

	static int one = 0;
	static int zero = 0;

	public int[] solution(int[][] arr) {
		dfs(arr, 0, 0, arr.length);

		return new int[] {zero, one};
	}

	public void dfs(int[][] arr, int y, int x, int current) {
		if (check(arr, y, x, current)) {
			if (arr[y][x] == 1) {
				one++;
			} else {
				zero++;
			}

			return;
		}

		int next = current / 2;

		dfs(arr, y, x, next);
		dfs(arr, y, x + next, next);
		dfs(arr, y + next, x, next);
		dfs(arr, y + next, x + next, next);
	}

	public boolean check(int[][] arr, int y, int x, int current) {
		int value = arr[y][x];

		for (int i = y; i < current + y; i++) {
			for (int j = x; j < current + x; j++) {
				if (arr[i][j] != value) {
					return false;
				}
			}
		}

		return true;
	}
}
