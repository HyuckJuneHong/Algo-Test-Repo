package src.문제_풀이_전략._5_정렬;

import static java.util.Objects.*;

import java.util.PriorityQueue;

public class Lv2_가장_큰_수 {

	public String solution(int[] numbers) {
		StringBuilder answer = new StringBuilder();
		PriorityQueue<Number> numberPq = new PriorityQueue<>();

		for (int number : numbers) {
			numberPq.add(new Number(number));
		}

		answer.append(requireNonNull(numberPq.poll()).number);

		if (answer.toString().equals("0")) {
			return "0";
		}

		while (!numberPq.isEmpty()) {
			answer.append(numberPq.poll().number);
		}

		return answer.toString();
	}

	public static class Number implements Comparable<Number> {

		String number;

		public Number(int number) {
			this.number = String.valueOf(number);
		}

		@Override
		public int compareTo(Number o) {
			int value1 = Integer.parseInt(o.number + this.number);
			int value2 = Integer.parseInt(this.number + o.number);
			return value1 - value2;
		}
	}
}
