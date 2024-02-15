package src.문제_풀이_전략._5_정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lv1_K번째_수 {

	public int[] solution(int[] array, int[][] commands) {
		List<Integer> answer = new ArrayList<>();

		for (int[] command : commands) {
			int[] temp = Arrays.copyOfRange(array, command[0] - 1, command[1]);
			Arrays.sort(temp);
			answer.add(temp[command[2] - 1]);
		}

		return answer.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}
}
