package src.알고리고.문제_풀이_전략._2_문자열;

public class Lv1_3진법_뒤집기 {

	public int solution(int n) {
		String temp = new StringBuilder(Integer.toString(n, 3))
			.reverse()
			.toString();

		return Integer.parseInt(temp, 3);
	}
}
