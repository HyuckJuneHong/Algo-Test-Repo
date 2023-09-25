package src.프로그래머스_코딩_테스트_문제_풀이_전략._6장;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        for (int w = 3; w <= 5000; w++) {
            for (int h = 3; h <= w; h++) {
                int b = 2 * (w + h - 2);
                int y = w * h - b;

                if (b == brown && y == yellow) {
                    return new int[]{w, h};
                }
            }
        }

        return new int[0];
    }
}
