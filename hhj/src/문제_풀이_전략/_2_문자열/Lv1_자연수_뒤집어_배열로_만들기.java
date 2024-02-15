package src.문제_풀이_전략._2_문자열;

import java.util.Arrays;

public class Lv1_자연수_뒤집어_배열로_만들기 {

	public int[] solution(long n) {
		StringBuilder sb = new StringBuilder(String.valueOf(n));

		return Arrays.stream(sb.reverse()
				.toString()
				.split(""))
			.mapToInt(Integer::parseInt)
			.toArray();
	}
}
