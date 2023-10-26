package src.알고리고.문제_풀이_전략._1_배열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
문제 풀이
1. 주어진(line) 직선들의 교점 중 정수값을 추출한다.
2. 정수값 중 최댓 x, y 위치와 최소 x, y를 구한다.
3. 구한 값으로 배열을 생성 후 별을 넣는다.
*/
public class lv2_교점에_별_만들기 {
    
    private static class Point {
        public final long y;
        public final long x;

        private Point(long y, long x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "[" + y + ", " + x + "]";
        }
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];

            for (int j = i + 1; j < line.length; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                Point point = getPoint(a, b, e, c, d, f);

                if (point != null) {
                    points.add(point);
                }
            }
        }

        Point max = getMaxPoint(points);
        Point min = getMinPoint(points);
        int height = (int) (max.y - min.y + 1);
        int width = (int) (max.x - min.x + 1);
        char[][] arr = new char[height][width];
        String[] answer = new String[height];

        for (int i = 0; i < height; i++) {
            Arrays.fill(arr[i], '.');
        }

        for (Point point : points) {
            int y = (int) (max.y - point.y);
            int x = (int) (point.x - min.x);
            arr[y][x] = '*';
        }

        for (int i = 0; i < height; i++) {
            answer[i] = String.valueOf(arr[i]);
        }

        return answer;
    }

    private Point getPoint(long a, long b, long e, long c, long d, long f) {
        double z = (double) (a * d - b * c);
        double x = (double) (b * f - e * d) / z;
        double y = (double) (e * c - a * f) / z;

        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long) y, (long) x);
    }

    private Point getMaxPoint(List<Point> points) {
        long y = Long.MIN_VALUE;
        long x = Long.MIN_VALUE;

        for (Point point : points) {
            if (point.y > y) {
                y = point.y;
            }

            if (point.x > x) {
                x = point.x;
            }
        }

        return new Point(y, x);
    }

    private Point getMinPoint(List<Point> points) {
        long y = Long.MAX_VALUE;
        long x = Long.MAX_VALUE;

        for (Point point : points) {
            if (point.y < y) {
                y = point.y;
            }

            if (point.x < x) {
                x = point.x;
            }
        }

        return new Point(y, x);
    }
}
