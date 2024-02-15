package src.문제_풀이_전략._3_재귀;

import java.util.ArrayList;
import java.util.List;

public class Lv2_모음사전 {

	static final String[] WORD = {"A", "E", "I", "O", "U"};

	static List<String> answer = new ArrayList<>();
	static boolean flag = false;

	public int solution(String word) {
		for (int i = 0; i < 5; i++) {
			dfs(word, WORD[i]);
		}

		return answer.size() + 1;
	}

	public void dfs(String word, String current) {
		if (flag || current.length() > 5) {
			return;
		}

		if (current.equals(word)) {
			flag = true;
			return;
		} else {
			answer.add(current);
		}

		for (int i = 0; i < 5; i++) {
			dfs(word, current + WORD[i]);
		}
	}
}
