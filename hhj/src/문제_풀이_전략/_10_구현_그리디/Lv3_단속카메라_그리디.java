package src.문제_풀이_전략._10_구현_그리디;

import java.util.Arrays;
import java.util.Comparator;

/**
 routes[][] : 고속도로를 이동하는 차량의 경로 (len=1~10_000, val[i][0,1] = -30_000~30_000 카메라 진입/진출 지점)
 return int : 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라가 필요한 지 반환

 1. routes를 [i][1] 최댓값으로 정렬을 하자.
 2. 가장 앞 진출에 카메라를 설치하고 만나지 않는 도로에 설치하면서 계속 나아가자.
 */
public class Lv3_단속카메라_그리디 {

	public int solution(int[][] routes) {
		int answer = 0;
		int camera = 30_001;

		Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

		for (int[] route : routes) {
			int start = route[0];
			int end = route[1];

			if (start <= camera && camera <= end) {
				continue;
			}

			camera = end;
			answer += 1;
		}

		return answer;
	}
}
