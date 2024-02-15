package src.문제_풀이_전략._8_동적_프로그래밍;

import java.util.Arrays;

/**
 arr : 문자열 형태의 숫자와 덧셈, 뺄셈 기호가 들어있는 1차원 배열 (len=3~201)
 return : 서로 다른 연산 순서의 계산 결과 중 최댓값

 1. +일 때, (최댓값 + 최댓값)
 2. -일 때, (최댓값 - 최솟값)
 3. 결국 return 값은 덧셈 혹은 뺄셈에 따라, 1번, 2번 공식을 따르면 된다.
 4. 마지막으로 메모이제이션(DP) 기법을 활용해 성능을 개선한다.
 */
public class Lv4_사칙연산 {

	static final int[][] MAX = new int[202][202];
	static final int[][] MIN = new int[202][202];

	public int solution(String arr[]) {
		for (int[] m : MAX) {
			Arrays.fill(m, Integer.MIN_VALUE);
		}

		for (int[] m : MIN) {
			Arrays.fill(m, Integer.MAX_VALUE);
		}

		return getMax(0, arr.length, arr);
	}

	private int getMax(int start, int end, String[] arr) {
		if (MAX[start][end] != Integer.MIN_VALUE) {
			return MAX[start][end];
		}

		if (end - start == 1) {
			return MAX[start][end] = Integer.parseInt(arr[start]);
		}

		int max = Integer.MIN_VALUE;

		for (int i = start + 1; i < end; i += 2) {
			int left = getMax(start, i, arr);
			int right;
			int result;

			if (arr[i].equals("+")) {
				right = getMax(i + 1, end, arr);
				result = left + right;
			} else {
				right = getMin(i + 1, end, arr);
				result = left - right;
			}

			if (max < result) {
				max = result;
			}
		}

		return MAX[start][end] = max;
	}

	private int getMin(int start, int end, String[] arr) {
		if (MIN[start][end] != Integer.MAX_VALUE) {
			return MIN[start][end];
		}

		if (end - start == 1) {
			return MIN[start][end] = Integer.parseInt(arr[start]);
		}

		int min = Integer.MAX_VALUE;

		for (int i = start + 1; i < end; i += 2) {
			int left = getMin(start, i, arr);
			int right;
			int result;

			if (arr[i].equals("+")) {
				right = getMin(i + 1, end, arr);
				result = left + right;
			} else {
				right = getMax(i + 1, end, arr);
				result = left - right;
			}

			if (min > result) {
				min = result;
			}
		}

		return MIN[start][end] = min;
	}
}
