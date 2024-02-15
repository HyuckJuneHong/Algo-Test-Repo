package src.프로그래머스.level2;

public class 삼각_달팽이 {
    static final int[] dx = {0, 1, -1};
    static final int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int index = 1;
        int x = 0;
        int y = 0;
        int d = 0;

        while (true) {
            arr[y][x] = index++;
            int nx = dx[d] + x;
            int ny = dy[d] + y;

            if (nx == n || ny == n || nx == -1 || ny == -1 || arr[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = dx[d] + x;
                ny = dy[d] + y;
            }

            if (nx == n || ny == n || nx == -1 || ny == -1 || arr[ny][nx] != 0) {
                break;
            }

            x = nx;
            y = ny;
        }

        int[] answer = new int[index - 1];
        int k = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[k++] = arr[i][j];
            }
        }

        return answer;
    }
}
