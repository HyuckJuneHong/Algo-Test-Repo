package src.프로그래머스_코딩_테스트_문제_풀이_전략._4장;

public class 숫자_문자열과_영단어2 {
    public int solution(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine"};

        for (int i = 0; i <= 9; i++) {
            s = s.replace(arr[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}
