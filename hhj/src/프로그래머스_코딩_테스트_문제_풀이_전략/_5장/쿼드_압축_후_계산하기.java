package src.프로그래머스_코딩_테스트_문제_풀이_전략._5장;

public class 쿼드_압축_후_계산하기 {

	static int one = 0;
	static int zero = 0;

	public int[] solution(int[][] arr) {
		dfs(arr, 0, 0, arr.length);

		return new int[] {zero, one};
	}

	private void dfs(int[][] arr, int y, int x, int size) {
		if (check(arr, y, x, size)) {
			if (arr[y][x] == 0) {
				zero++;
			} else {
				one++;
			}

			return;
		}

		int mid = size / 2;
		dfs(arr, y, x, mid);
		dfs(arr, y + mid, x, mid);
		dfs(arr, y, x + mid, mid);
		dfs(arr, y + mid, x + mid, mid);
	}

	private boolean check(int[][] arr, int y, int x, int size) {
		int v = arr[y][x];

		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (arr[i][j] != v) {
					return false;
				}
			}
		}

		return true;
	}
}
