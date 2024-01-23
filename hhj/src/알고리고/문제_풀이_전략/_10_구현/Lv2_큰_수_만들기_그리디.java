package src.알고리고.문제_풀이_전략._10_구현;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 number : 문자열 형식의 숫자
 k : 제거할 수의 갯수
 return String : number에서 k개의 수를 제거헀을 때 만들 수 있는 가장 큰 숫자

 1. Stack을 생성해서 number를 담는다
 2. k가 0보다 클 때, 현재 스택에 들어있는 모든 값이 num보다 작으면 해당 값을 뺀다.
 3. stack을 출력한다.
 */
public class Lv2_큰_수_만들기_그리디 {

	public String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		Deque<Integer> stack = new ArrayDeque<>();

		for (char num : number.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(num - '0');
				continue;
			}

			while (!stack.isEmpty() && stack.peek() < (num - '0') && k > 0) {
				stack.pop();
				k--;
			}

			stack.push(num - '0');
		}

		while (!stack.isEmpty()) {
			int current = stack.pop();

			if (k > 0) {
				k--;
				continue;
			}

			answer.append(current);
		}

		return answer.reverse()
			.toString();
	}
}
