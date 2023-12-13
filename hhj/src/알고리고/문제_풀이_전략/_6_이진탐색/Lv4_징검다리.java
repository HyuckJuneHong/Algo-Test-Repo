package src.알고리고.문제_풀이_전략._6_이진탐색;

import java.util.Arrays;

/**
 바위 n개 제거 시, 각 바위 사이의 최소거리로 나올 수 있는 값들 중에서 가장 큰 값 구하는 문제

 이분탐색을 하려면, 어떤 변수를 이분탐색의 값으로 할지를 정해야 한다.
 - 위 사이의 간격의 최솟값이 최대화 -> 바위 사이의 간격을 기준
 - 즉, 이분탐색으로 설정하는 하는 것 -> 바위를 제거할 간격을 기준

 시작과 끝이 30만큼 떨어져있다고 가정
 - 시작 부터 끝까지 나올 수 있는 바위 사이의 최대 간격은 모든 바위를 제거한 경우 30
 - 이분 탐색을 통해, 최소 거리를 탐색.
 - 처음은 중간 값인 15만큼의 거리가 나올 때까지 바위를 제거.
 - 제거한 바위 사이의 간격이 15가 나올 것이란 보장이 없기에 앞부터 하나씩 제거
 - 두 바위 사이의 간격이 15미만 이면, 바위를 계속 제거, 초과 하면, 기준을 현재 위치로 변경.
 - 제거된 바위의 개수가 n개 이하면 더 큰 최솟 값을 바랄 수 있음 -> low 부분을 현재 위치로
 - n을 초과 시, 현재 값이 더 낮아야 바위를 n보다 적게 제거함 -> high 부분을 현재 위치로

 주의할 점
 - 약간의 속임수 존재 -> 바위는 무조건 n개를 제거 해야 함.
 - 하지만, 아무리 제거 해도, 최솟 값이 더 이상 발생 하지 않음
 - 즉, n개의 바위 제거 전에 바위 사이의 최소 간격이 최대 구간이 되는 부분이 발생

 1. 어떤 바위가 아닌, 지점 사이의 최소 거리 d를 구하면 된다.
 - 가장 작은 거리는 1 이상 이다.
 1. 바위 위치 앞부터 순회
 2. 인접한 바위 사이 거리를 구하고 해당 거리가 d보다 작으면 바위 하나를 없앤다.
 3. 모두 반복 했을 때, 바위를 없앤 개수가 n과 같거나 작다면 d는 조건을 만족.
 */
public class Lv4_징검다리 {

	public int solution(int distance, int[] rocks, int n) {
		rocks = Arrays.copyOf(rocks, rocks.length + 1);
		rocks[rocks.length - 1] = distance;
		Arrays.sort(rocks);

		return binarySearch(distance, rocks, n);
	}

	private int binarySearch(int distance, int[] rocks, int n) {
		int start = 1;
		int end = distance + 1;

		while (end - start > 1) {
			int mid = (start + end) / 2;

			if (isValid(mid, rocks, n)) {
				start = mid;
				continue;
			}

			end = mid;
		}

		return start;
	}

	private boolean isValid(int mid, int[] rocks, int n) {
		int removed = 0;
		int current = 0;

		for (int rock : rocks) {
			if (rock - current < mid) {
				removed++;
				continue;
			}

			current = rock;
		}

		return removed <= n;
	}
}
