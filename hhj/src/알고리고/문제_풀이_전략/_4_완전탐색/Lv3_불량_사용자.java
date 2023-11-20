package src.알고리고.문제_풀이_전략._4_완전탐색;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 문제풀이
 1. banned_id의 각각 일치하는 경우를 모두 구한다.
 - 서로 길이가 다르면 실패
 - 문자 하나하나 검사 시작 -> *일 경우 패스
 2. 구한 모든 경우를 대조하며 갯수를 구한다.
 - 각 밴 사용자에 대응하는 경우들을 Set에 넣는다.
 - depth를 증가하며 ban 길이와 같아지면, 종료한다.
 */
public class Lv3_불량_사용자 {

	static Set<Set<String>> answer = new HashSet<>();

	public int solution(String[] user_id, String[] banned_id) {
		List<List<String>> result = new ArrayList<>();
		matches(result, user_id, banned_id);
		dfs(result, 0, new HashSet<>());

		return answer.size();
	}

	public void dfs(List<List<String>> result, int depth, Set<String> sum) {
		if (result.size() == depth) {
			answer.add(new HashSet<>(sum));
			return;
		}

		for (String id : result.get(depth)) {
			if (sum.contains(id)) {
				continue;
			}

			sum.add(id);
			dfs(result, depth + 1, sum);
			sum.remove(id);
		}
	}

	public void matches(List<List<String>> result, String[] user_id, String[] banned_id) {
		for (String banned : banned_id) {
			List<String> list = new ArrayList<>();

			for (String user : user_id) {
				boolean flag = true;

				if (user.length() != banned.length()) {
					continue;
				}

				for (int i = 0; i < user.length(); i++) {
					if (banned.charAt(i) == '*') {
						continue;
					}

					if (banned.charAt(i) != user.charAt(i)) {
						flag = false;
						break;
					}
				}

				if (flag) {
					list.add(user);
				}
			}

			result.add(list);
		}
	}
}
