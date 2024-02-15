package src.programmers.level2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 리코쳇_로봇 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static int[][] dis;
    static int n = 0, m = 0;
    static Point start;

    public int solution(String[] board) {
        init(board);

        return bfs();
    }

    private int bfs() {
        Deque<Point> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            Point p = q.poll();
            int y = p.y;
            int x = p.x;

            if (map[y][x] == 'G') {
                return dis[y][x];
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                int nd = dis[y][x] + 1;

                while (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (map[ny][nx] == 'D') {
                        break;
                    }

                    ny += dy[i];
                    nx += dx[i];
                }

                ny -= dy[i];
                nx -= dx[i];

                if (dis[ny][nx] > nd) {
                    q.add(new Point(ny, nx));
                    dis[ny][nx] = nd;
                }
            }
        }

        return -1;
    }

    private void init(String[] board) {
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        dis = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);

            for (int j = 0; j < m; j++) {
                char current = board[i].charAt(j);
                map[i][j] = current;

                if (current == 'R') {
                    start = new Point(i, j);
                    dis[i][j] = 0;
                }
            }
        }
    }

    public static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
