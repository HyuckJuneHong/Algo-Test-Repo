package src.알고리고.문제_풀이_전략._9_큐;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 progresses[] : 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 (len<=100, val<100)
 speeds[] : 각 작업의 개발 속도가 적힌 정수 배열 (len<=100, val<=100)
 return : 각 배포마다 몇 개의 기능이 배포되는지 (배포는 하루에 한 번 가능, 하우의 끝에 이루어짐)

 1. 큐의 현재 진도 수보다 큰게 나올 때까지 계속 담는다.
 2. 큰게 나오면 큐의 현재 사이즈를 저장하고 초기화 한 후 1번부터 다시 반복한다.
 */
public class Lv2_기능개발_Queue {

	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> answer = new ArrayList<>();
		Deque<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < speeds.length; i++) {
			double remain = 100.0 - progresses[i];
			int day = (int)Math.ceil(remain / speeds[i]);

			if (!queue.isEmpty() && queue.peek() < day) {
				answer.add(queue.size());
				queue.clear();
			}

			queue.add(day);
		}

		answer.add(queue.size());

		return answer.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}
}
