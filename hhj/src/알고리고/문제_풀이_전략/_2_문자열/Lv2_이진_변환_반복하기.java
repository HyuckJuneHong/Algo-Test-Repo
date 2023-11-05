package src.알고리고.문제_풀이_전략._2_문자열;

/**
 문제 풀이
 1. 이진 변환을 하는 메서드 생성
 2. 해당 메서드를 s가 "1"이 될 때까지 반복
 */
public class Lv2_이진_변환_반복하기 {

	static int zeroCount = 0;
	static int convertCount = 0;

	public int[] solution(String s) {
		while (!s.equals("1")) {
			s = convert(s);
			convertCount++;
		}

		return new int[] {convertCount, zeroCount};
	}

	public String convert(String s) {
		int count = 0;

		for (char c : s.toCharArray()) {
			if (c == '1') {
				count++;
			} else {
				zeroCount++;
			}
		}

		return Integer.toString(count, 2);
	}
}
