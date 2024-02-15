package src.문제_풀이_전략._8_동적_프로그래밍;

public class Lv2_피보나치_수 {

	int[] arr = new int[100_001];

	public int solution(int n) {
		return fibo(n);
	}

	public int fibo(int n) {
		if (arr[n] >= 1) {
			return arr[n];
		}

		if (n <= 2) {
			return arr[n] = 1;
		}

		return arr[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
	}
}
