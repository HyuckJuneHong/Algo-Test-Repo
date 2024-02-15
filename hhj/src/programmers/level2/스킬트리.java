package src.programmers.level2;

import java.util.HashMap;

class 스킬트리 {

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		HashMap<Character, Integer> skills = new HashMap<>();

		for (int i = 0; i < skill.length(); i++) {
			skills.put(skill.charAt(i), i);
		}

		for (String skill_tree : skill_trees) {
			int index = 0;
			boolean flag = true;

			for (int i = 0; i < skill_tree.length(); i++) {
				char current = skill_tree.charAt(i);

				if (skills.containsKey(current)) {
					if (skills.get(current) != index) {
						flag = false;
						break;
					}

					index++;
				}
			}

			if (flag) {
				answer++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] arr = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution("CBD", arr));
	}
}
