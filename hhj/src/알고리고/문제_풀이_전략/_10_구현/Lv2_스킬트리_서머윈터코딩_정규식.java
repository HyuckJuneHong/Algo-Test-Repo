package src.알고리고.문제_풀이_전략._10_구현;

/**
 skill : 선행 스킬 순서 (len=1~26, ex="A->B->C"이면 "ABC")
 skill_trees[] : 유저들이 만든 스킬트리를 담은 배열 (len=1~20, val=1~26, 중복 X)
 return int : 가능한 스킬트리 개수

 흐름

 1. skill_trees의 각 스킬트리를 꺼낸다.
 2. 꺼낸 스킬트리를 제외한 스킬은 제거한다.
 3. 제거한 스킬트리와 skill이 일치하면 answer를 증가한다.
 */
public class Lv2_스킬트리_서머윈터코딩_정규식 {

	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		String regExp = "[^" + skill + "]";

		for (String skillTree : skill_trees) {
			skillTree = skillTree.replaceAll(regExp, "");

			if (skill.startsWith(skillTree)) {
				answer++;
			}
		}

		return answer;
	}
}
