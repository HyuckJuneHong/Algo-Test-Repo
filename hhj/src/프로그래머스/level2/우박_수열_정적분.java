package src.프로그래머스.level2;

import java.util.ArrayList;
import java.util.List;

public class 우박_수열_정적분 {

    static List<Double> list = new ArrayList<>();
    static List<Double> area = new ArrayList<>();

    public double[] solution(
            int k,          // 우박수 초항
            int[][] ranges  // 정적분을 구하는 구간들의 목록
    ) {
        double[] answer = new double[ranges.length];
        init(k);
        generateArea();

        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = list.size() + ranges[i][1] - 1;

            if (a > b) {
                answer[i] = -1;
                continue;
            }

            for (int j = a; j < b; j++) {
                answer[i] += area.get(j);
            }
        }

        return answer;
    }

    public void generateArea() {
        for (int i = 0; i < list.size() - 1; i++) {
            double y = list.get(i) + list.get(i + 1);
            area.add(y / 2);
        }
    }

    public void init(int k) {
        while (k >= 1) {
            list.add((double) k);

            if (k == 1) {
                return;
            }

            if (k % 2 == 0) {
                k /= 2;
                continue;
            }

            k = k * 3 + 1;
        }
    }
}
