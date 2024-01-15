package src.알고리고.문제_풀이_전략._9_트리_유니온파인드_트라이;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 words[] : 가사에 사용된 모든 단어들이 담긴 배열 (len=2~100_000, val=1~10_000, 중복 X, 소문자)
 queries[] : 찾고자 하는 키워드가 담긴 배열 (len=2~100_000, val=1~10_000, 중복 O, 소문자와 '?')
 return int[] : 각 키워드 별로 매치된 단어가 몇 개인지 순서대로 배열에 담아 반환

 1. words의 각 가사 단어의 문자들로 순방향과 역방향 트라이를 만들 노드 클래스를 만든다
 - 노드는 자식을 나타낼 Map이 있다.
 - 노드는 현재 노드에서 만들 수 있는 단어 갯수를 나타낼 Map이 있다.
 2. 노드를 하나씩 이어가면서 트라이를 만들 add(word, index) 함수를 만든다.
 - word : 최종적으로 만들어지는 가사 단어
 - index : 현재 추가할 문자 위치
 3. 현재 문자의 갯수를 찾아낼 getCount(word, index)함수를 만든다.
 - word : 찾을 단어
 - index : 현재 단어에서 비교할 문자 위치
 */
public class Lv4_가사_검색_카카오_트라이 {

	public int[] solution(String[] words, String[] queries) {
		List<Integer> answer = new ArrayList<>();
		Node trie = new Node();
		Node reverseTrie = new Node();

		for (String word : words) {
			String reverseWord = new StringBuilder(word).reverse().toString();

			trie.add(word, 0);
			reverseTrie.add(reverseWord, 0);
		}

		for (String query : queries) {
			if (query.charAt(0) != '?') {
				answer.add(trie.getCount(query, 0));
				continue;
			}

			String reverseQuery = new StringBuilder(query).reverse().toString();

			answer.add(reverseTrie.getCount(reverseQuery, 0));
		}

		return answer.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}

	private static class Node {

		Map<Integer, Integer> counts = new HashMap<>();
		Map<Character, Node> nodes = new HashMap<>();

		public void add(String word, int index) {
			int remain = word.length() - index;

			counts.put(remain, counts.getOrDefault(remain, 0) + 1);

			if (remain > 0) {
				char current = word.charAt(index);
				Node node = nodes.getOrDefault(current, new Node());

				node.add(word, index + 1);
				nodes.put(current, node);
			}
		}

		public int getCount(String word, int index) {
			char current = word.charAt(index);
			int remain = word.length() - index;

			if (current == '?') {
				return counts.getOrDefault(remain, 0);
			}

			if (!nodes.containsKey(current)) {
				return 0;
			}

			return nodes.get(current).getCount(word, index + 1);
		}
	}
}
