package src.문제_풀이_전략._10_구현_그리디;

import java.util.HashSet;
import java.util.Set;

/**
 n : 전체 학생 수 (2~30)
 lost[] : 체육복을 도난당한 학생들의 번호가 담긴 배열 (1~n, 중복 X)
 reserve[] : 여벌 체육복을 가져온 학생들 번호가 담긴 배열 (1~n, 중복 X)
 return int : 체육수업을 들을 수 있는 학생의 최댓값

 1. lost Set 생성
 2. reserve set 생성
 3. reserve 기준 앞뒤번호가 lostSet에 있으면 lost 제거
 4. n - lost.size 반환
 */
public class LV1_체육복_그리디 {

	public int solution(int n, int[] lost, int[] reserve) {
		Set<Integer> lostSet = new HashSet<>();
		Set<Integer> reserveSet = new HashSet<>();

		for (int i : lost) {
			lostSet.add(i);
		}

		for (int i : reserve) {
			if (lostSet.contains(i)) {
				lostSet.remove(i);
				continue;
			}

			reserveSet.add(i);
		}

		for (int i : reserveSet) {
			if (lostSet.contains(i - 1)) {
				lostSet.remove(i - 1);
			} else if (lostSet.contains(i + 1)) {
				lostSet.remove(i + 1);
			}
		}

		return n - lostSet.size();
	}
}
