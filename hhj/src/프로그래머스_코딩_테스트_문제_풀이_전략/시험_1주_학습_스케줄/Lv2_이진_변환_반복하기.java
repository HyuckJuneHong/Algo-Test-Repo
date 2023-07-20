package src.프로그래머스_코딩_테스트_문제_풀이_전략.시험_1주_학습_스케줄;

public class Lv2_이진_변환_반복하기 {
    //150_000
    public int[] solution(String s) {
        int remove = 0;
        int change = 0;

        while (!s.equals("1")) {
            int zeros = countZeros(s);
            int ones = s.length() - zeros;
            s = Integer.toString(ones, 2);
            remove += zeros;
            change++;
        }

        return new int[]{change, remove};
    }

    public int countZeros(String s) {
        int zero = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                zero++;
            }
        }

        return zero;
    }
}
