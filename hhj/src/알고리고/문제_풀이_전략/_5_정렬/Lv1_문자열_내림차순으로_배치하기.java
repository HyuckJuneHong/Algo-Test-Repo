package src.알고리고.문제_풀이_전략._5_정렬;

import java.util.Arrays;

public class Lv1_문자열_내림차순으로_배치하기 {

	public String solution(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);

		return new StringBuilder(new String(c))
			.reverse()
			.toString();
	}
}
