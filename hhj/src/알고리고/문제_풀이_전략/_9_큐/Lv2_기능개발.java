package src.알고리고.문제_풀이_전략._9_큐;

import java.util.ArrayList;
import java.util.List;

/**
 progresses[] : 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 (len<=100, val<100)
 speeds[] : 각 작업의 개발 속도가 적힌 정수 배열 (len<=100, val<=100)
 return : 각 배포마다 몇 개의 기능이 배포되는지 (배포는 하루에 한 번 가능, 하우의 끝에 이루어짐)

 1. 일단 모든 나머지 진도를 구한다.
 2. 현재(current) 진도 남은 수보다 큰게 나올 때까지 count한다
 3. 큰게 나오면 현재 count 값을 저장하고 current를 교채하고 count도 1로 초기화한 후 2번부터 다시 반복한다.
 */
public class Lv2_기능개발 {

	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> answer = new ArrayList<>();
		int[] success = new int[speeds.length];
		int current = 0;
		int count = 1;

		for (int i = 0; i < speeds.length; i++) {
			double remain = 100.0 - progresses[i];
			success[i] = (int)Math.ceil(remain / speeds[i]);
		}

		current = success[0];

		for (int i = 1; i < speeds.length; i++) {
			if (current >= success[i]) {
				count++;
				continue;
			}

			answer.add(count);
			current = success[i];
			count = 1;
		}

		answer.add(count);

		return answer.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}
}
