package src.알고리고.문제_풀이_전략._8_동적_프로그래밍;

public class Lv2_피보나치_수_DP {

	public int solution(int n) {
		int[] answer = new int[100_001];

		answer[0] = 0;
		answer[1] = 1;

		for (int i = 2; i <= n; i++) {
			answer[i] = (answer[i - 1] + answer[i - 2]) % 1234567;
		}

		return answer[n];
	}
}
