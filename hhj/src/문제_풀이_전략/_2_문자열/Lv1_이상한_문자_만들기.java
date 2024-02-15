package src.문제_풀이_전략._2_문자열;

public class Lv1_이상한_문자_만들기 {

	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		char[] arr = s.toCharArray();
		int index = 0;

		for (char c : arr) {
			if (c == ' ') {
				index = 0;
				sb.append(" ");
				continue;
			}

			if (index % 2 == 0) {
				c = Character.toUpperCase(c);
			} else {
				c = Character.toLowerCase(c);
			}

			index++;
			sb.append(c + "");
		}

		return sb.toString();
	}
}
