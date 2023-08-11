package src.프로그래머스_코딩_테스트_문제_풀이_전략._4장;

public class _3진법_뒤집기 {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder(Integer.toString(n, 3));
        int answer = Integer.parseInt(sb.reverse().toString(), 3);

        return answer;
    }
}
