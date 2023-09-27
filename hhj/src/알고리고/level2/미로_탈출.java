package src.알고리고.level2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 미로_탈출 {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int time = 0;
    static char[][] miro;
    static Point l, s;
    static int n, m;

    public int solution(String[] maps) {
        init(maps);

        if (!bfs(s, 'L', new int[n][m])) {
            return -1;
        }

        if (!bfs(l, 'E', new int[n][m])) {
            return -1;
        }

        return time;
    }

    public boolean bfs(Point sp, char end, int[][] dis) {
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], 10000);
        }

        Deque<Point> q = new ArrayDeque<>();
        q.add(sp);
        dis[sp.y][sp.x] = time;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (miro[p.y][p.x] == end) {
                time = dis[p.y][p.x];
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                int current = dis[p.y][p.x] + 1;
                ;

                if (ny >= 0 && nx >= 0 && ny < n && nx < m && miro[ny][nx] != 'X' && dis[ny][nx] > current) {
                    dis[ny][nx] = current;
                    q.add(new Point(ny, nx));
                }
            }
        }

        return false;
    }

    public void init(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        miro = new char[n][m];

        for (int i = 0; i < n; i++) {
            char[] map = maps[i].toCharArray();

            for (int j = 0; j < m; j++) {
                miro[i][j] = map[j];

                if (miro[i][j] == 'S') {
                    s = new Point(i, j);
                } else if (miro[i][j] == 'L') {
                    l = new Point(i, j);
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
