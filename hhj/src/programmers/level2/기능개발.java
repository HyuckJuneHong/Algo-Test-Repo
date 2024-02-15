package src.programmers.level2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 기능개발 {

	/**
	 * 1. 기능 개선 작업 수행 중
	 * 2. 각 기능은 진도가 100%일 때 서비스에 반영 가능
	 * 3. 기능 개발 순서는 없음
	 * 4. 단, 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포
	 * 5. 배포는 하루에 한 번만 가능하고 하루의 끝에 이루어짐
	 * 6. 예를 들어, 진도율이 95%인 작업 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어짐
	 * <p>
	 * - progresses : 작업의 진도가 적힌 정수 배열
	 * - speeds : 각 작업의 개발 속도가 적힌 정수 배열
	 * - return : 각 배포마다 몇 개의 기능이 배포되는 지
	 */
	public int[] solution(int[] progresses,
		int[] speeds) {
		Deque<Integer> remain = new ArrayDeque<>();
		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < progresses.length; i++) {
			int result = (int)Math.ceil((100 - progresses[i]) / (float)speeds[i]);

			if (!remain.isEmpty() && remain.peek() < result) {
				answer.add(remain.size());
				remain.clear();
			}

			remain.offer(result);
		}

		answer.add(remain.size());

		return answer.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}
}
