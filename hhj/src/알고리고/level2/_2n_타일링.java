package src.알고리고.level2;

public class _2n_타일링 {
    public int solution(int n) {
        int[] answer = new int[60_001];
        answer[0] = 1;
        answer[1] = 1;

        for (int i = 0; i <= n; i++) {
            answer[i] = dfs(n, i, answer);
        }

        return answer[n];
    }

    private int dfs(int n, int depth, int[] answer) {
        if (answer[depth] != 0) {
            return answer[depth];
        }

        return answer[depth] = (dfs(n, depth - 1, answer) + dfs(n, depth - 2, answer)) % 1_000_000_007;
    }
}
