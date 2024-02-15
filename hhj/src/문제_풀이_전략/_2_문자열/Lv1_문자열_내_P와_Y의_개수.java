package src.문제_풀이_전략._2_문자열;

public class Lv1_문자열_내_P와_Y의_개수 {

	boolean solution(String s) {
		int count = 0;

		for (char c : s.toCharArray()) {
			if (c == 'p' || c == 'P') {
				count++;
			} else if (c == 'y' || c == 'Y') {
				count--;
			}
		}

		return count == 0;
	}
}
