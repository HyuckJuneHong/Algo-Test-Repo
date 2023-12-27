package src.알고리고.문제_풀이_전략._9_스택;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 s : 대, 중, 소괄호로 이루어진 문자열
 return : 왼쪽으로 회전 시, 올바른 문자열 갯수

 1. 올바른 문자열인지 판단
 - 가장 첫 괄호는 열린 괄호여야 한다.
 - 가장 처음으로 발견한 닫힌 괄호는 마지막으로 발견한 열린 괄호와 같아야 한다.
 - 닫힌 괄호를 발견 했을 시, 발견한 해당 괄호의 열린 괄호 갯수가 1 이상이어야 한다.
 2. 왼쪽으로 한칸 옮긴 후 올바른 문자열인지 판단
 */
public class Lv2_괄호_회전하기_월간코드챌린지 {

	public int solution(String s) {
		int answer = 0;

		for (int i = 0; i < s.length(); i++) {
			if (validate(s)) {
				answer++;
			}

			s = s.substring(1) + s.charAt(0);
		}

		return answer;
	}

	private boolean validate(String s) {
		Deque<Character> stack = new ArrayDeque<>();

		for (char c : s.toCharArray()) {
			switch (c) {
				case '(' -> stack.push(')');
				case '{' -> stack.push('}');
				case '[' -> stack.push(']');
				case ')', '}', ']' -> {
					if (stack.isEmpty()) {
						return false;
					}

					if (stack.pop() != c) {
						return false;
					}
				}
			}
		}

		return stack.isEmpty();
	}
}
