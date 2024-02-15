package src.문제_풀이_전략._2_문자열;

public class Lv1_문자열_다루기 {

	public boolean solution(String s) {
		if (s.length() != 4 && s.length() != 6) {
			return false;
		}

		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
