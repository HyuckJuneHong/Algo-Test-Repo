package src.문제_풀이_전략._4_완전탐색;

public class Lv2_카펫 {

	public int[] solution(int brown, int yellow) {
		for (int i = 1; i <= yellow; i++) {
			if (yellow % i == 0) {
				int width = yellow / i + 2;
				int height = i + 2;

				if (width * height == brown + yellow) {
					return new int[] {width, height};
				}
			}
		}

		return null;
	}
}
