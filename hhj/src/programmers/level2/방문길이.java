package src.programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 방문길이 {
    public int solution(String dirs) {
        return bfs(dirs, 11, 11);
    }

    public static int bfs(String dirs, int n, int m) {
        Point current = new Point(5, 5);
        Set<String> paths = new HashSet<>();

        for (char dir : dirs.toCharArray()) {
            int nx = current.x;
            int ny = current.y;

            if (dir == 'U') {
                ny += 1;
            } else if (dir == 'D') {
                ny -= 1;
            } else if (dir == 'R') {
                nx += 1;
            } else if (dir == 'L') {
                nx -= 1;
            }

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                nx = current.x;
                ny = current.y;
                continue;
            }

            String path = current.x + "," + current.y + "," + nx + "," + ny;
            String reversePath = nx + "," + ny + "," + current.x + "," + current.y;

            if (!paths.contains(path) && !paths.contains(reversePath)) {
                paths.add(path);
            }

            current.x = nx;
            current.y = ny;
        }

        return paths.size();
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
