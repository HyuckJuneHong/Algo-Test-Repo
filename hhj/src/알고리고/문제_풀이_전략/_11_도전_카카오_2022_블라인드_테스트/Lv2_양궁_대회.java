package src.알고리고.문제_풀이_전략._11_도전_카카오_2022_블라인드_테스트;

public class Lv2_양궁_대회 {

	static final int[] SCORE = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

	static int[] answer = new int[11];
	static int max = Integer.MIN_VALUE;

	public int[] solution(int n, int[] info) {

		dfs(info, new int[11], n, 0, 0);

		return max == Integer.MIN_VALUE ? new int[] {-1} : answer;
	}

	private static void dfs(int[] apeach, int[] ryan, int n, int depth, int start) {
		if (depth == n) {
			int diff = getDiff(apeach, ryan);

			if (diff > max) {
				max = diff;
				answer = ryan.clone();
			} else if (diff == max && isPrior(answer, ryan)) {
				answer = ryan.clone();
			} else {
				for (int i = start; i < 11; i++) {
					ryan[i]++;
					dfs(apeach, ryan, n, depth + 1, i);
					ryan[i]--;
				}
			}
		}
	}

	private static int getDiff(int[] apeach, int[] ryan) {
		int diff = 0;

		for (int i = 0; i < 11; i++) {
			if (apeach[i] == 0 && ryan[i] == 0) {
				continue;
			}

			if (apeach[i] >= ryan[i]) {
				diff -= SCORE[i];
			} else {
				diff += SCORE[i];
			}
		}

		return diff;
	}

	private static boolean isPrior(int[] com1, int[] com2) {
		for (int i = 10; i >= 0; i--) {
			if (com1[i] != com2[i]) {
				return com1[i] < com2[i];
			}
		}

		return false;
	}
}
