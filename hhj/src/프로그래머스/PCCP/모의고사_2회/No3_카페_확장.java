package src.프로그래머스.PCCP.모의고사_2회;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class No3_카페_확장 {

	private int answer = 0;
	private int currentUser = 0;
	private int currentTime = 0;
	private final Queue<Integer> readyQ = new LinkedList<>();
	private final Deque<Integer> endQ = new ArrayDeque<>();

	public int solution(int[] menu, int[] order, int k) {
		for (int o : order) {
			readyQ.add(menu[o]);
		}

		while (!readyQ.isEmpty()) {
			if (endQ.isEmpty()) {
				endQ.add(currentTime + readyQ.poll());
				currentUser += 1;
			}

			while (!readyQ.isEmpty() && !endQ.isEmpty() && currentTime + k < endQ.peek()) {
				currentTime += k;
				currentUser += 1;
				endQ.add(endQ.peekLast() + readyQ.poll());
			}

			answer = Math.max(currentUser, answer);
			currentUser -= 1;
			endQ.poll();
		}

		return answer;
	}
}
