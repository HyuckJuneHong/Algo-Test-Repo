package src.문제_풀이_전략._4_완전탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 문제 풀이
 1) 모든 경우의 수를 만든다.
 2) List로 expression을 분리해 순서대로 넣는다.
 3) List를 반복하며 경우의 수에 따른 순서로 계산하여 List를 줄여나간다.
 4) 마지막 하나 남은 List를 비교한다.
 */
public class Lv2_수식_최대화_카카오인턴십 {

	static final char[][] PRIORITY = {
		{'*', '+', '-'},
		{'*', '-', '+'},
		{'-', '*', '+'},
		{'-', '+', '*'},
		{'+', '*', '-'},
		{'+', '-', '*'},
	};

	public long solution(String expression) {
		long answer = 0;
		StringTokenizer st = new StringTokenizer(expression, "-+*", true);
		List<String> expressions = new ArrayList<>();

		while (st.hasMoreTokens()) {
			expressions.add(st.nextToken());
		}

		for (char[] priority : PRIORITY) {
			List<String> copyExpressions = new ArrayList<>(expressions);

			for (int j = 0; j < PRIORITY[0].length; j++) {
				char currentOperation = priority[j];

				for (int k = 0; k < copyExpressions.size() - 2; k++) {
					char operation = copyExpressions.get(k + 1).charAt(0);

					if (currentOperation == operation) {
						String first = copyExpressions.get(k);
						String second = copyExpressions.get(k + 2);
						String result = calculate(first, operation, second);
						copyExpressions.set(k, result);
						copyExpressions.remove(k + 1);
						copyExpressions.remove(k + 1);
						k--;
					}
				}
			}

			answer = Math.max(answer, Math.abs(Long.parseLong(copyExpressions.get(0))));
		}

		return answer;
	}

	private String calculate(String first, char operation, String second) {
		long number1 = Long.parseLong(first);
		long number2 = Long.parseLong(second);

		if (operation == '+') {
			return String.valueOf(number1 + number2);
		}

		if (operation == '-') {
			return String.valueOf(number1 - number2);
		}

		return String.valueOf(number1 * number2);
	}
}
