package src.programmers.level2;

public class 가장_큰_정사각형_찾기 {
	public int solution(int[][] board) {
		int answer = 0;
		int n = board.length;
		int m = board[0].length;

		if (n == 1 & m == 1) {
			return 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (board[i][j] == 1) {
					int up = board[i][j - 1];
					int left = board[i - 1][j];
					int upLeft = board[i - 1][j - 1];
					int min = Math.min(up, Math.min(left, upLeft));
					board[i][j] = min + 1;
					answer = Math.max(answer, board[i][j]);
				}
			}
		}

		return answer * answer;
	}
}
