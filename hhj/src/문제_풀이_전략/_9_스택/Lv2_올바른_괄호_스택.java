package src.문제_풀이_전략._9_스택;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lv2_올바른_괄호_스택 {

	boolean solution(String s) {
		Deque<Integer> stack = new ArrayDeque<>();

		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(1);
				continue;
			}

			if (stack.isEmpty()) {
				return false;
			}

			stack.pop();
		}

		return stack.isEmpty();
	}
}
