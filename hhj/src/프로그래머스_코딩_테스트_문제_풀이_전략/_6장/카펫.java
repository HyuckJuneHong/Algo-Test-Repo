package src.프로그래머스_코딩_테스트_문제_풀이_전략._6장;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        for (int i = 3; i <= 5000; i++) {
            for (int j = 3; j <= i; j++) {
                int b = (i + j - 2) * 2;
                int y = i * j - b;

                if (brown == b && yellow == y) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}
