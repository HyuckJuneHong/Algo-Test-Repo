package src.programmers.level2;

public class 거리두기_확인하기 {

    static final int N = 5;
    static final int[] DX = {-1, 0, 1, 0};
    static final int[] DY = {0, 1, 0, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[N];
        int index = 0;

        for (String[] place : places) {
            char[][] ready = new char[N][N];

            for (int i = 0; i < N; i++) {
                ready[i] = place[i].toCharArray();
            }

            if (isDistance(ready)) {
                answer[index++] = 1;
            } else {
                answer[index++] = 0;
            }
        }

        return answer;
    }

    private boolean isDistance(char[][] ready) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ready[i][j] == 'P' && !check(ready, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean check(char[][] ready, int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + DY[i];
            int nx = x + DX[i];

            if (ny < 0 || nx < 0 || ny == N || nx == N) {
                continue;
            }

            if (ready[ny][nx] == 'P') {
                return false;
            }

            if (ready[ny][nx] == 'O' && !check(ready, ny, nx, y, x)) {
                return false;
            }
        }

        return true;
    }

    private boolean check(char[][] ready, int y, int x, int ey, int ex) {
        for (int i = 0; i < 4; i++) {
            int ny = y + DY[i];
            int nx = x + DX[i];

            if (ny < 0 || nx < 0 || ny == N || nx == N || (ny == ey && nx == ex)) {
                continue;
            }

            if (ready[ny][nx] == 'P') {
                return false;
            }
        }

        return true;
    }
}
