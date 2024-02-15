package src.문제_풀이_전략._9_스택;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 prices : 초 단위로 기록된 주식가격 (len=2~100_000, val=1~10_000)
 return : 가격이 떨어지지 않은 기간(단위: 초)

 1. 상승장이면 스택에 현재 시점을 저장한다.
 2. 하락장이 발견 시(prices[현 스택 값] > 현재 주식가격), 현재 시점 - 현 스택 값을 answer에 저장 후 스택에서 제거
 3. 2번을 현재 시점보다 하락장일 때까지 반복.
 4. 3번에 해당하는 경우가 없으면, 다시 1번 시작
 5. 끝까지 갔다면, (prices 크기 - 현 스택 값 - 1)을 answer 저장 후 스택에서 제거. 단 answer == 0일 때만 수행
 */
public class Lv2_주식가격 {

	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0);

		for (int i = 1; i < prices.length; i++) {
			while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
				int current = stack.pop();
				answer[current] = i - current;
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int current = stack.pop();
			answer[current] = prices.length - current - 1;
		}

		return answer;
	}
}
