package src.프로그래머스.PCCP.모의고사_2회;

import java.util.PriorityQueue;
import java.util.Queue;

public class No2_신입사원_교육 {
	public int solution(int[] ability, int number) {
		Queue<Integer> pq = new PriorityQueue<>();

		for (int a : ability) {
			pq.add(a);
		}

		for (int i = 0; i < number; i++) {
			Integer result = pq.poll() + pq.poll();

			pq.add(result);
			pq.add(result);
		}

		return pq.stream()
			.mapToInt(Integer::intValue)
			.sum();
	}
}
