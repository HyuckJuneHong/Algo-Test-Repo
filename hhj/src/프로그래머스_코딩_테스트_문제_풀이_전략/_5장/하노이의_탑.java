package src.프로그래머스_코딩_테스트_문제_풀이_전략._5장;

import java.util.ArrayList;
import java.util.List;

/**
 * [문제풀이]
 * 1) n개를 from에서 to로 옮긴다. => (n, from, to)
 * 2) n-1개의 from을 empty로 옮긴다. => (n-1, from, empty) => empty = 6 - from - to => 3기둥이 1,2,3을 나타내기 때문
 * 3) 1개의 from을 to로 옮긴다. => (1, from, to)
 * 4) n-1개의 empty를 to로 옮긴다. => (n-1, empty, to)
 */
public class 하노이의_탑 {

    static List<int[]> answer = new ArrayList<>();

    public int[][] solution(int n) {
        dfs(n, 1, 2, 3);

        return answer.toArray(int[][]::new);
    }

    private void dfs(int n, int from, int empty, int to) {
        if (n == 1) {
            answer.add(new int[]{from, to});

            return;
        }

        dfs(n - 1, from, to, empty);
        dfs(1, from, empty, to);
        dfs(n - 1, empty, from, to);
    }
}
