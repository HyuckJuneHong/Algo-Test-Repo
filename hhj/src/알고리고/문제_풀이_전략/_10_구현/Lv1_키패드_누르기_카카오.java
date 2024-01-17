package src.알고리고.문제_풀이_전략._10_구현;

import java.util.Map;

/**
 numbers[] : 순서대로 누를 번호가 담긴 배열 (len=1~1_000, val=0~9)
 hand : 왼손, 오른손잡이인 지를 나타내는 문자열 ("left" or "right")
 return String : 각 번호를 누른 엄지손가락이 왼손, 오른손인 지 나타내는 연속된 문자열 형태 (왼손 사용="L", 오른손 사용="R")

 1. 1, 4, 7인 경우 무조건 L 사용
 2. 3, 6, 7인 경우 무조건 R 사용
 3. 2, 5, 8, 0일 경우 |누를 번호 - 현재 위치| 비교
 */
public class Lv1_키패드_누르기_카카오 {

	private static class Point {

		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public void move(Point point) {
			this.y = point.y;
			this.x = point.x;
		}

		public int getDistance(Point point) {
			return Math.abs(this.y - point.y) + Math.abs(this.x - point.x);
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Point) {
				Point p = (Point)o;
				return this.y == p.y && this.x == p.x;
			}

			return false;
		}
	}

	private final Map<Integer, Point> pointMap = Map.of(
		1, new Point(0, 0),
		2, new Point(0, 1),
		3, new Point(0, 2),
		4, new Point(1, 0),
		5, new Point(1, 1),
		6, new Point(1, 2),
		7, new Point(2, 0),
		8, new Point(2, 1),
		9, new Point(2, 2),
		0, new Point(3, 1)
	);

	public String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();

		Point left = new Point(3, 0);
		Point right = new Point(3, 2);

		for (int number : numbers) {
			Point next = pointMap.get(number);

			if (number == 1 || number == 4 || number == 7) {
				left.move(next);
				answer.append("L");
			} else if (number == 3 || number == 6 || number == 9) {
				right.move(next);
				answer.append("R");
			} else {
				String result = compareAndClick(left, right, next, hand);
				answer.append(result);
			}
		}

		return answer.toString();
	}

	public String compareAndClick(Point left, Point right, Point next, String hand) {
		int ld = left.getDistance(next);
		int rd = right.getDistance(next);

		if (ld > rd || (ld == rd && hand.equals("right"))) {
			right.move(next);
			return "R";
		} else {
			left.move(next);
			return "L";
		}
	}
}
