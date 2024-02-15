package src.programmers.level2;

class 숫자변환하기 {
    static int[] answer;

    public int solution(int x, int y, int n) {
        if (x == y) {
            return 0;
        }

        answer = new int[y + 1];

        dp(x, y, n);

        return answer[y] == 0 ? -1 : answer[y];
    }

    public void dp(int x, int y, int n) {
        for (int i = x; i <= y; i++) {

            if (i != x && answer[i] == 0) {
                continue;
            }

            if (i * 2 <= y) {
                answer[i * 2] = answer[i * 2] == 0 ? answer[i] + 1 : Math.min(answer[i * 2], answer[i] + 1);
            }

            if (i * 3 <= y) {
                answer[i * 3] = answer[i * 3] == 0 ? answer[i] + 1 : Math.min(answer[i * 3], answer[i] + 1);
            }

            if (i + n <= y) {
                answer[i + n] = answer[i + n] == 0 ? answer[i] + 1 : Math.min(answer[i + n], answer[i] + 1);
            }
        }
    }
}
