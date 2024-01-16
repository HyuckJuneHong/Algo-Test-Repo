package src.알고리고.문제_풀이_전략._10_구현;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 skill : 선행 스킬 순서 (len=1~26, ex="A->B->C"이면 "ABC")
 skill_trees[] : 유저들이 만든 스킬트리를 담은 배열 (len=1~20, val=1~26, 중복 X)
 return int : 가능한 스킬트리 개수

 흐름
 1. skill_trees의 각 스킬트리를 꺼낸다.
 2. 꺼낸 스킬트리가 가능한 스킬트리인지 검사한다.

 검사 과정
 1. skill을 Set과 Queue에 담는다.
 2. skill_tree를 꺼내 해당 스킬이 Set에 포함한지 확인한다.
 - 포함하지 않으면 통과
 - 포함하면 Queue의 peek()가 비교한다.
 - 다르면, 불가능한 스킬트리
 - 같으면, 가능한 스킬트리
 */
public class Lv2_스킬트리_서머윈터코딩 {

	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		Set<Character> set = new HashSet<>();
		Queue<Character> queue = new LinkedList<>();

		for (char s : skill.toCharArray()) {
			set.add(s);
			queue.add(s);
		}

		for (String skillTree : skill_trees) {
			boolean flag = true;
			Set<Character> checkSet = new HashSet<>(set);
			Queue<Character> checkQueue = new LinkedList<>(queue);

			for (char s : skillTree.toCharArray()) {
				if (!checkSet.contains(s) || checkQueue.isEmpty()) {
					continue;
				}

				if (checkQueue.peek() != s) {
					flag = false;
					break;
				}

				checkSet.remove(checkQueue.poll());
			}

			if (flag) {
				answer++;
			}
		}

		return answer;
	}
}
