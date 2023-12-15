package src.알고리고.문제_풀이_전략._7_해시;

import java.util.HashMap;
import java.util.Map;

public class Lv0_A로_B_만들기 {

	public int solution(String before, String after) {
		Map<Character, Integer> answer = new HashMap<>();

		for (char c : before.toCharArray()) {
			answer.put(c, answer.getOrDefault(c, 0) + 1);
		}

		for (char c : after.toCharArray()) {
			if (!answer.containsKey(c)) {
				return 0;
			}

			answer.put(c, answer.get(c) - 1);

			if (answer.get(c) == 0) {
				answer.remove(c);
			}
		}

		return answer.isEmpty() ? 1 : 0;
	}
}
