package src.프로그래머스_코딩_테스트_문제_풀이_전략._3장;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [문제 풀이]
 * - 모든 직선 쌍에 대해 반복 : 1_000 * 3 = 3_000 (통과)
 * - 교점 좌표 구하기
 * - 정수 좌표만 저장하기
 * - 저장된 정수들의 x, y 좌표 최댓값, 최솟값 구하기
 * - 최대, 최소 값들 이용해 2차원 배열 크기 결정
 * - 2차원 배열에 별 표시
 * - 문자열 배열로 변환 후 반환
 */
public class 교점에_별_만들기 {
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point point = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);

                if (point != null) {
                    points.add(point);
                }
            }
        }

        Point minPoint = getMinPoint(points);
        Point maxPoint = getMaxPoint(points);
        int x = (int) (maxPoint.x - minPoint.x + 1);
        int y = (int) (maxPoint.y - minPoint.y + 1);
        char[][] arr = new char[y][x];

        for (int i = 0; i < y; i++) {
            Arrays.fill(arr[i], '.');
        }

        for (Point point : points) {
            int ix = (int) (point.x - minPoint.x);
            int iy = (int) (maxPoint.y - point.y);
            arr[iy][ix] = '*';
        }

        String[] answer = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]);
            }

            answer[i] = sb.toString();
        }

        return answer;
    }

    private Point getMaxPoint(List<Point> list) {
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for (Point p : list) {
            if (maxX < p.x) {
                maxX = p.x;
            }

            if (maxY < p.y) {
                maxY = p.y;
            }
        }

        return new Point(maxX, maxY);
    }

    private Point getMinPoint(List<Point> list) {
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for (Point p : list) {
            if (minX > p.x) {
                minX = p.x;
            }

            if (minY > p.y) {
                minY = p.y;
            }
        }

        return new Point(minX, minY);
    }

    private Point intersection(long x1, long y1, long c1, long x2, long y2, long c2) {
        double x = (double) (y1 * c2 - c1 * y2) / (x1 * y2 - y1 * x2);
        double y = (double) (c1 * x2 - x1 * c2) / (x1 * y2 - y1 * x2);

        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long) x, (long) y);
    }

    public class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
