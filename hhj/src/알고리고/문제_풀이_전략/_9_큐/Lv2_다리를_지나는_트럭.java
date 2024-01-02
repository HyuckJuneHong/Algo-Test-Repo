package src.알고리고.문제_풀이_전략._9_큐;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 bridge_length : 다리에 올라갈 수 있는 트럭 수
 weight : 다리가 견딜 수 있는 무게
 truck_weights : 트럭 별 무게를 담은 1차원 배열
 return : 모든 트럭이 건너려면 최소 몇 초가 걸리는 지

 1. 다리를 생성 후 0으로 채운다. (큐)
 2. 대기 중인 트럭을 큐에 담는다.
 3. 현재 대기 중인 트럭이 건널 수 있는 지 확인한다.
 4. 건널 수 있다면, 다리(큐)에 트럭 무게를 담고 건널 수 없다면 다시 0을 담는다.
 5. 3, 4를 대기 중인 트럭이 모두 다리에 올라갔다면, 마지막 트럭이 나오는데 걸리는 시간을 더해 반환한다.
 */
public class Lv2_다리를_지나는_트럭 {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Deque<Integer> bridge = new ArrayDeque<>();
		Deque<Integer> ready = new ArrayDeque<>();

		for (int i = 0; i < bridge_length; i++) {
			bridge.add(0);
		}

		for (int truck : truck_weights) {
			ready.add(truck);
		}

		while (!ready.isEmpty()) {
			weight += bridge.poll();
			answer += 1;

			if (weight - ready.peek() < 0) {
				bridge.add(0);
				continue;
			}

			weight -= ready.peek();
			bridge.add(ready.poll());
		}

		return answer + bridge_length;
	}
}
