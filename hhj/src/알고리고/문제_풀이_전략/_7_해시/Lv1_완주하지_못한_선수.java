package src.알고리고.문제_풀이_전략._7_해시;

import java.util.HashMap;
import java.util.Map;

public class Lv1_완주하지_못한_선수 {

	public String solution(String[] participant, String[] completion) {
		Map<String, Integer> answer = new HashMap<>();

		for (String name : participant) {
			answer.put(name, answer.getOrDefault(name, 0) + 1);
		}

		for (String name : completion) {
			answer.put(name, answer.get(name) - 1);

			if (answer.get(name) == 0) {
				answer.remove(name);
			}
		}

		return answer.keySet()
			.iterator()
			.next();
	}
}
