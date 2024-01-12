package src.알고리고.문제_풀이_전략._9_힙_우선순위큐;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 operations : 이중 우선순위 큐가 할 연산을 담은 1차원 배열 (len=1~1_000_000, val=["명령어 값"])
 - "I 숫자" : 숫자 삽입
 - "D 1" : 최댓값 삭제
 - "D -1" : 최솟값 삭제
 return : 연산 처리 후 큐가 비어있으면 [0, 0] 비어있지 않으면 [최대, 최소]

 1. PriorityQueue를 활용해 operations의 명령어들을 수행한다.
 2. 이때, 최대, 최소를 알기 위해 PriorityQueue 필드를 2개 선언한다.
 */
public class Lv3_우선순위_큐 {

	public int[] solution(String[] operations) {
		Queue<Integer> pq = new PriorityQueue<>();
		Queue<Integer> rpq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int[] answer = new int[2];

		for (String operation : operations) {
			char command = operation.charAt(0);
			int value = Integer.parseInt(operation.split(" ")[1]);

			if (command != 'D') {
				pq.add(value);
				rpq.add(value);
				continue;
			}

			if (value == 1) {
				pq.remove(rpq.poll());
			} else {
				rpq.remove(pq.poll());
			}
		}

		if (!rpq.isEmpty()) {
			answer[0] = rpq.poll();
			rpq.remove(answer[0]);
		}

		if (!pq.isEmpty()) {
			answer[1] = pq.poll();
		}

		return answer;
	}
}
