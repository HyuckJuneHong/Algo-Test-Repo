package src.programmers.알고리고.level2;

import java.util.ArrayList;
import java.util.List;

public class N_2_배열_자르기 {
    /**
     * 1. [n, n] 2차원 배열 생성
     * 2. 1행 1열부터 [i, i]까지 모든 빈칸 i로 채우기
     * 3. n행을 잘라내 모두 이어붙인 새로운 1차원 배열 생성
     * 4. 새 1차원 배열에서 [left] ~ [right]만 추출
     */
    public static int[] solution(int n,
                                 long left,
                                 long right) {
        List<Integer> answer = new ArrayList<>();

        for (long i = left; i <= right; i++) {
            int value = (int) (Math.max(i / n, i % n) + 1);
            answer.add(value);
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
