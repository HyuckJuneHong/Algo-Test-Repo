package src.프로그래머스_코딩_테스트_문제_풀이_전략._4장;

public class 이진_변환_반복하기 {
    static int count = 0;
    static int zero = 0;

    public int[] solution(String s) {

        while (!s.equals("1")) {
            int remove = countZeros(s);
            s = Integer.toString(s.length() - remove, 2);
            zero += remove;
            count += 1;
        }

        return new int[]{count, zero};
    }

    private int countZeros(String s) {
        int result = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                result++;
            }
        }

        return result;
    }
}
