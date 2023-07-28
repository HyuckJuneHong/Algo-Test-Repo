package src.프로그래머스_코딩_테스트_문제_풀이_전략._3장;

public class 삼각_달팽이 {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int[] dx = {0, 1, -1};
        int[] dy = {1, 0, -1};
        int x = 0;
        int y = 0;
        int v = 0;
        int d = 0;

        while (true) {
            triangle[y][x] = ++v;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
            }

            if (nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                break;
            }

            x = nx;
            y = ny;
        }

        int[] answer = new int[v];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }

        return answer;
    }
}
