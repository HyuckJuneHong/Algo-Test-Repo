package src.programmers.level2;

public class _2n_타일링 {
    static int[] answer;

    public int solution(int n) {
        answer = new int[60_001];

        for (int i = 0; i <= n; i++) {
            fibo(n, i);
        }

        return answer[n];
    }

    public void fibo(int n, int depth) {
        if (depth < 2) {
            answer[depth] = 1;
            return;
        }

        if (answer[depth] != 0) {
            return;
        }

        answer[depth] = (answer[depth - 1] + answer[depth - 2]) % 1_000_000_007;
    }
}
