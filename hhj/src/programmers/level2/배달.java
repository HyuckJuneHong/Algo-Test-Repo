package src.programmers.level2;

import java.util.*;

public class 배달 {
    static List<List<Point>> graph = new ArrayList<>();
    static int[] dis;
    static int answer = 0;

    public int solution(int N, int[][] road, int K) {
        init(road, N);
        bfs(K);

        for (int i = 0; i < N; i++) {
            if (dis[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    private void bfs(int K) {
        Deque<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point current = q.poll();

            for (Point next : graph.get(current.b)) {
                if (dis[next.b] > current.c + next.c) {
                    dis[next.b] = current.c + next.c;
                    q.add(new Point(next.b, dis[next.b]));
                }
            }
        }
    }

    private void init(int[][] road, int N) {
        dis = new int[N];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : road) {
            int a = r[0] - 1;
            int b = r[1] - 1;
            int c = r[2];
            graph.get(a).add(new Point(b, c));
            graph.get(b).add(new Point(a, c));
        }
    }

    public static class Point {
        int b;
        int c;

        public Point(int b, int c) {
            this.b = b;
            this.c = c;
        }
    }
}
