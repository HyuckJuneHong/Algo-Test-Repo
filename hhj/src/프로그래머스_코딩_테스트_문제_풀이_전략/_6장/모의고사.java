package src.프로그래머스_코딩_테스트_문제_풀이_전략._6장;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    static int[][] n = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    static int[] size = {5, 8, 10};
    static int max = 0;
    static int[] result = new int[3];

    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        test(answers);

        for (int i = 0; i < 3; i++) {
            if (max == result[i]) {
                answer.add(i + 1);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public void test(int[] answers) {
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                int index = i % size[j];

                if (answers[i] == n[j][index]) {
                    result[j] += 1;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            max = Math.max(max, result[i]);
        }
    }
}
