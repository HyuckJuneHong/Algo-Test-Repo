package src.문제_풀이_전략._9_투_포인터;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 gems[]: 진열대 번호 순서대로 보석들의 이름이 저장된 1차원 배열
 return [시작 + 1, 끝 + 1] : 모든 보석을 하나 이상 포함하는 가장 짧은 구간

 1. A(Set)에 gems를 담아 진열대 보석을 찾는다.
 2-1. lt=0, rt=1로 두고 lt==rt가 될 때까지 반복하면서, 구간을 찾는다.
 2-2. rt를 1씩 증가시키며 B(Map) 크기가 A 크기와 같아질 때까지, gem을 B에 담는다.
 2-3. A와 B 크기가 같아지면 lt를 증가시키며 B의 크기가 A 크기보다 작아질 때까지, B에서 삭제한다.
 2-4. 작아질 때 해당 구간을 기억한다.
 */
public class Lv3_보석_쇼핑 {

	public int[] solution(String[] gems) {
		int[] answer = new int[2];
		int lt = 0, rt = 0, size = 0, max = 100_000;
		Set<String> set = new HashSet<>(List.of(gems));
		Map<String, Integer> map = new HashMap<>();

		size = gems.length;

		while (lt < size) {
			if (rt < size && map.size() < set.size()) {
				String gem = gems[rt];
				map.put(gem, map.getOrDefault(gem, 0) + 1);
				rt += 1;
			} else if (map.size() == set.size()) {
				String gem = gems[lt++];
				map.put(gem, map.get(gem) - 1);

				if (map.get(gem) == 0) {
					map.remove(gem);
				}

				if (max > rt - lt) {
					answer[0] = lt;
					answer[1] = rt;
					max = rt - lt;
				}
			} else {
				break;
			}
		}

		return answer;
	}
}
