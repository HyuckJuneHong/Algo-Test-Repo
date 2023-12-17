package src.알고리고.문제_풀이_전략._7_해시;

import java.util.HashMap;
import java.util.Map;

public class Lv1_없는_숫자_더하기_월간코드챌린지 {

	public int solution(int[] numbers) {
		Map<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i <= 9; i++) {
			map.put(i, false);
		}

		for (int number : numbers) {
			map.put(number, true);
		}

		return map.entrySet().stream()
			.filter(entry -> !entry.getValue())
			.mapToInt(Map.Entry::getKey)
			.sum();
	}
}
