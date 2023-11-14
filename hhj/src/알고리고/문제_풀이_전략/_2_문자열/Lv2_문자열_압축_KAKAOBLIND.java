package src.알고리고.문제_풀이_전략._2_문자열;

/**
 1. 문자열 절반 길이만큼 순차적으로 반복
 2. 해당 길이의 문자로 압축 했을 때 길이 추출
 3. 추출한 길이가 최솟값이면 저장
 */
public class Lv2_문자열_압축_KAKAOBLIND {

	public int solution(String s) {
		int answer = s.length();

		for (int i = 1; i < s.length(); i++) {
			answer = Math.min(answer, compress(s, i));
		}

		return answer;
	}

	public int compress(String s, int n) {
		String start = s.substring(0, n);
		StringBuilder sb = new StringBuilder();
		int count = 0;
		int index = 0;

		while (index + n <= s.length()) {
			String current = s.substring(index, index + n);
			index += n;

			if (start.equals(current)) {
				count++;
				continue;
			}

			if (count != 1) {
				sb.append(count);
			}

			sb.append(start);
			start = current;
			count = 1;
		}

		if (count != 1) {
			sb.append(count);
		}

		sb.append(start);
		String last = s.substring(index);

		if (!last.isBlank()) {
			sb.append(last);
		}

		return sb.length();
	}
}
