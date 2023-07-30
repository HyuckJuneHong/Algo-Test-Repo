package src.프로그래머스_코딩_테스트_문제_풀이_전략._4장;

public class 시저_암호 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        char nc = ' ';

        for (char c : arr) {
            if (c == ' ') {
                sb.append(" ");
                continue;
            }

            if (c >= 'a' && c <= 'z') {
                nc = (char) ((c - 'a' + n) % ('z' - 'a' + 1) + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                nc = (char) ((c - 'A' + n) % ('Z' - 'A' + 1) + 'A');
            }

            sb.append(nc + "");
        }

        return sb.toString();
    }
}
