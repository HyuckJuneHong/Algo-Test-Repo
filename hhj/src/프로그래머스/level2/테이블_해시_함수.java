package src.프로그래머스.level2;

import java.util.Arrays;

public class 테이블_해시_함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            }

            return o1[col - 1] - o2[col - 1];
        });

        for (int i = row_begin - 1; i < row_end; i++) {
            int index = i + 1;
            int result = Arrays.stream(data[i])
                    .map(value -> value % index)
                    .sum();

            answer ^= result;
        }

        return answer;
    }
}
