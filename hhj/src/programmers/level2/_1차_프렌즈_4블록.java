package src.programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1차_프렌즈_4블록 {

    static int answer = 0;
    static char[][] dis;
    static boolean[][] visit;

    public int solution(int m, int n, String[] board) {
        dis = new char[m][n];
        visit = new boolean[m][n];
        init(m, n, board);
        check(m, n);

        return answer;
    }

    private void init(int m, int n, String[] board) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dis[i][j] = board[i].charAt(j);
            }
        }
    }

    private void check(int m, int n) {
        boolean flag = true;

        while (flag) {
            flag = false;

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {

                    if (dis[i][j] == '-') {
                        continue;
                    }

                    char current = dis[i][j];

                    if (current == dis[i][j + 1] &&
                            current == dis[i + 1][j] &&
                            current == dis[i + 1][j + 1]) {
                        visit[i][j] = true;
                        visit[i][j + 1] = true;
                        visit[i + 1][j] = true;
                        visit[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }

            remove(m, n);
            visit = new boolean[m][n];
        }
    }

    private void remove(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j]) {
                    dis[i][j] = '#';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Deque<Character> queue = new ArrayDeque<>();

            for (int j = m - 1; j >= 0; j--) {
                if (dis[j][i] == '#') {
                    answer++;
                } else {
                    queue.offer(dis[j][i]);
                }
            }

            int index = m - 1;

            while (!queue.isEmpty()) {
                dis[index--][i] = queue.poll();
            }

            for (int j = index; j >= 0; j--) {
                dis[j][i] = '-';
            }
        }
    }
}
