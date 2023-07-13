package src.알고리고.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 게임_맵_최단거리 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Deque<Point> points = new ArrayDeque<>();
    static int answer = 0;

    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] dis = new int[n][m];
        bfs(maps, dis, n, m);
        return answer;
    }

    public static void bfs(int[][] maps, int[][] dis, int n, int m) {
        Point start = new Point(0, 0);
        points.offer(start);
        maps[0][0] = 0;

        while (!points.isEmpty()) {
            Point current = points.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1) {
                    maps[nx][ny] = 0;
                    points.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[current.x][current.y] + 1;
                }
            }
        }

        answer = dis[n - 1][m - 1] == 0 ? -1 : dis[n - 1][m - 1] + 1;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
