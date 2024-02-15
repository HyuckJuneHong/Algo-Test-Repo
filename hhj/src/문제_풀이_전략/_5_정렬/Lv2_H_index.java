package src.문제_풀이_전략._5_정렬;

import java.util.Arrays;

public class Lv2_H_index {

	public int solution(int[] citations) {
		int answer = 0;
		int n = citations.length;
		citations = Arrays.stream(citations)
			.boxed()
			.sorted((v1, v2) -> v2 - v1)
			.mapToInt(Integer::intValue)
			.toArray();

		for (int h = 1; h <= n; h++) {
			int citation = citations[h - 1];

			if (h > citation) {
				break;
			}

			answer++;
		}

		return answer;
	}
}
