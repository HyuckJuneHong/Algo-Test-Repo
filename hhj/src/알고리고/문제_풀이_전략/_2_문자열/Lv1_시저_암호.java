package src.알고리고.문제_풀이_전략._2_문자열;

public class Lv1_시저_암호 {

	public String solution(String s, int n) {
		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];

			if (c == ' ') {
				continue;
			}

			if (c >= 'a' && c <= 'z') {
				arr[i] = (char)((c - 'a' + n) % (26) + 'a');
				continue;
			}

			arr[i] = (char)((c - 'A' + n) % (26) + 'A');
		}

		return new String(arr);
	}
}
