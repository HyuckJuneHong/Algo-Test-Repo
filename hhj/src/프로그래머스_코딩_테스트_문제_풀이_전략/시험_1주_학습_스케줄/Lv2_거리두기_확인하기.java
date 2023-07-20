package src.프로그래머스_코딩_테스트_문제_풀이_전략.시험_1주_학습_스케줄;

public class Lv2_거리두기_확인하기 {
    static final int SIZE = 5;
    static final int[] dx = {0, 1, -1, 0};
    static final int[] dy = {1, 0, 0, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[SIZE];
        int index = 0;

        for (String[] place : places) {
            char[][] room = new char[SIZE][SIZE];

            for (int i = 0; i < SIZE; i++) {
                room[i] = place[i].toCharArray();
            }

            if (isDistance(room)) {
                answer[index++] = 1;
            } else {
                answer[index++] = 0;
            }
        }

        return answer;
    }

    //유저를 발견하면 검사 시작
    public boolean isDistance(char[][] room) {
        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {

                if (room[i][j] != 'P') {
                    continue;
                }

                if (!isDistance(room, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    //거리 1 측정
    public boolean isDistance(char[][] room, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= SIZE || ny >= SIZE || nx < 0 || ny < 0) {
                continue;
            }

            char current = room[nx][ny];

            if (current == 'P') {
                return false;
            }

            if (current == 'O' && !isDistance(room, nx, ny, 3 - i)) {
                return false;
            }
        }

        return true;
    }

    //거리 2 측정
    public boolean isDistance(char[][] room, int x, int y, int ex) {
        for (int i = 0; i < 4; i++) {

            if (i == ex) {
                continue;
            }

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= SIZE || ny >= SIZE || nx < 0 || ny < 0) {
                continue;
            }

            if (room[nx][ny] == 'P') {
                return false;
            }
        }

        return true;
    }
}
