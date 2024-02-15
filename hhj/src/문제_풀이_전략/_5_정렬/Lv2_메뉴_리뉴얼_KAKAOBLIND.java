package src.문제_풀이_전략._5_정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 문제 풀이
 1. course의 값 기준으로 메뉴 구성을 만들어 Map 넣는다.
 - 최소 2가지 이상의 단품 메뉴 구성
 - 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합
 - 값으로 오름차순 정렬
 2. Map Key을 꺼내서 문자열 배열에 넣어 반환
 */
public class Lv2_메뉴_리뉴얼_KAKAOBLIND {

	static Map<String, Integer> menu = new HashMap<>();

	public String[] solution(String[] orders, int[] course) {
		List<String> answer = new ArrayList<>();

		for (int i = 0; i < orders.length; i++) {
			char[] order = orders[i].toCharArray();
			Arrays.sort(order);
			orders[i] = String.valueOf(order);
		}

		for (int count : course) {
			int max = 0;
			menu.clear();

			for (String order : orders) {
				if (order.length() < count) {
					continue;
				}

				boolean[] visited = new boolean[order.length()];
				dfs(order, count, 0, 0, "", visited);
			}

			for (Map.Entry<String, Integer> entry : menu.entrySet()) {
				max = Math.max(max, entry.getValue());
			}

			for (Map.Entry<String, Integer> entry : menu.entrySet()) {
				if (max != 1 && max == entry.getValue()) {
					answer.add(entry.getKey());
				}
			}
		}

		return answer.stream()
			.sorted()
			.toArray(String[]::new);
	}

	public void dfs(String order, int course, int depth, int index, String sum, boolean[] visited) {
		if (course == depth) {
			menu.put(sum, menu.getOrDefault(sum, 0) + 1);
			return;
		}

		for (int i = index; i < order.length(); i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			dfs(order, course, depth + 1, i + 1, sum + order.charAt(i), visited);
			visited[i] = false;
		}
	}
}
