package src.프로그래머스_코딩_테스트_문제_풀이_전략._4장;

public class 문자열_내_p와_y의_개수 {
    boolean solution(String s) {
        s = s.toLowerCase();

        int p = s.length() - s.replace("p", "").length();
        int y = s.length() - s.replace("y", "").length();

        return p == y;
    }
}
