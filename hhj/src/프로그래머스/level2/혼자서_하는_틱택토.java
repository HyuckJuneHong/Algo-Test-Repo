package src.프로그래머스.level2;

public class 혼자서_하는_틱택토 {

    static char[][] dis = new char[3][3];
    static int[] count = new int[2];
    static boolean[] bingo = new boolean[2];

    public int solution(String[] board) {
        init(board);
        game(board);

        if (!check()) {
            return 0;
        }

        return 1;
    }

    public void game(String[] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i].equals("OOO")) {
                bingo[0] = true;
            } else if (board[i].equals("XXX")) {
                bingo[1] = true;
            }
        }

        if ((dis[0][0] == 'O' && dis[1][0] == 'O' && dis[2][0] == 'O') ||
                (dis[0][1] == 'O' && dis[1][1] == 'O' && dis[2][1] == 'O') ||
                (dis[0][2] == 'O' && dis[1][2] == 'O' && dis[2][2] == 'O')) {
            bingo[0] = true;
        }

        if ((dis[0][0] == 'X' && dis[1][0] == 'X' && dis[2][0] == 'X') ||
                (dis[0][1] == 'X' && dis[1][1] == 'X' && dis[2][1] == 'X') ||
                (dis[0][2] == 'X' && dis[1][2] == 'X' && dis[2][2] == 'X')) {
            bingo[1] = true;
        }

        if ((dis[0][0] == 'O' && dis[1][1] == 'O' && dis[2][2] == 'O') ||
                (dis[0][2] == 'O' && dis[1][1] == 'O' && dis[2][0] == 'O')) {
            bingo[0] = true;
        }

        if ((dis[0][0] == 'X' && dis[1][1] == 'X' && dis[2][2] == 'X') ||
                (dis[0][2] == 'X' && dis[1][1] == 'X' && dis[2][0] == 'X')) {
            bingo[1] = true;
        }
    }

    public boolean check() {
        int o = count[0];
        int x = count[1];

        if (bingo[0] && bingo[1]) {
            return false;
        }

        if (bingo[0]) {
            return o > x && o - x == 1;
        }

        if (bingo[1]) {
            return o == x;
        }

        if (o - x < 0 || o - x > 1) {
            return false;
        }

        if (o > 5) {
            return false;
        }

        return x <= 4;
    }

    public void init(String[] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char b = board[i].charAt(j);
                dis[i][j] = b;

                if (b == 'O') {
                    count[0]++;
                } else if (b == 'X') {
                    count[1]++;
                }
            }
        }
    }
}
