package src.문제_풀이_전략._6_이진탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lv2_순위_검색_KAKAOBLIND {

	static Map<String, List<Integer>> infos = new HashMap<>();

	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		for (String i : info) {
			String[] key = i.split(" ");
			int score = Integer.parseInt(key[4]);
			dfs(key, score, 0, "");
		}

		for (List<Integer> scores : infos.values()) {
			Collections.sort(scores);
		}

		for (int i = 0; i < query.length; i++) {
			String[] queries = query[i].split(" and ");
			String[] foodAndScore = queries[3].split(" ");
			String food = foodAndScore[0];
			int score = Integer.parseInt(foodAndScore[1]);
			String key = queries[0] + queries[1] + queries[2] + food;

			if (infos.containsKey(key)) {
				List<Integer> scores = infos.get(key);
				answer[i] = scores.size() - binarySearch(scores, score);
			}
		}

		return answer;
	}

	private void dfs(String[] key, int score, int depth, String sum) {
		if (key.length - 1 == depth) {
			infos.putIfAbsent(sum, new ArrayList<>());
			infos.get(sum).add(score);
			return;
		}

		dfs(key, score, depth + 1, sum + key[depth]);
		dfs(key, score, depth + 1, sum + "-");
	}

	private int binarySearch(List<Integer> scores, int targetScore) {
		int left = 0;
		int right = scores.size();

		while (left < right) {
			int mid = (left + right) / 2;

			if (scores.get(mid) >= targetScore) {
				right = mid;
				continue;
			}

			left = mid + 1;
		}

		return left;
	}
}
