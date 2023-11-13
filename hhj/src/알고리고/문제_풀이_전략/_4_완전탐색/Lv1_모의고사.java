package src.알고리고.문제_풀이_전략._4_완전탐색;

import java.util.ArrayList;
import java.util.List;

public class Lv1_모의고사 {

	static final int[] ONE = {1, 2, 3, 4, 5};
	static final int[] TWO = {2, 1, 2, 3, 2, 4, 2, 5};
	static final int[] THREE = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

	public int[] solution(int[] answers) {
		List<Integer> answer = test(answers);

		return answer.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}

	public List<Integer> test(int[] answers) {
		List<Integer> result = new ArrayList<>();
		int[] counts = new int[3];

		for (int i = 0, index = 0; i < answers.length; i++, index++) {
			if (ONE[index % ONE.length] == answers[i]) {
				counts[0]++;
			}

			if (TWO[index % TWO.length] == answers[i]) {
				counts[1]++;
			}

			if (THREE[index % THREE.length] == answers[i]) {
				counts[2]++;
			}
		}

		int max = Math.max(counts[0], Math.max(counts[1], counts[2]));

		for (int i = 0; i < 3; i++) {
			if (max == counts[i]) {
				result.add(i + 1);
			}
		}

		return result;
	}
}
