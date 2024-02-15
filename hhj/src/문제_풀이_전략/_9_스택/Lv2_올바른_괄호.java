package src.문제_풀이_전략._9_스택;

public class Lv2_올바른_괄호 {

	boolean solution(String s) {
		int count = 0;

		for (char c : s.toCharArray()) {
			if (c == '(') {
				count++;
				continue;
			}

			if (count == 0) {
				return false;
			}

			count--;
		}

		return count == 0;
	}
}
