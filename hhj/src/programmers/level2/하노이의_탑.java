package src.programmers.level2;

import java.util.ArrayList;
import java.util.List;

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
