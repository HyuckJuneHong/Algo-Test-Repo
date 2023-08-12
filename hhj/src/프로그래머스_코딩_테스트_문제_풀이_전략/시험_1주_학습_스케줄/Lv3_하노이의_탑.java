package src.프로그래머스_코딩_테스트_문제_풀이_전략.시험_1주_학습_스케줄;

import java.util.ArrayList;
import java.util.List;

public class Lv3_하노이의_탑 {
    static List<int[]> answer = new ArrayList<>();

    public int[][] solution(int n) {
        dfs(n, 1, 3);
        return answer.toArray(new int[0][]);
    }

    public void dfs(int n, int from, int to) {
        if (n == 1) {
            answer.add(new int[]{from, to});
            return;
        }

        int empty = 6 - from - to;

        dfs(n - 1, from, empty);
        dfs(1, from, to);
        dfs(n - 1, empty, to);
    }
}
