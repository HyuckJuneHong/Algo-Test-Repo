package src;
/**
 목표
 - 학업성과 기준으로 절반을 나눈 우/열반을 운영
 - 학업성과 = 학생이 쌓은 득점 (단, 동일 시, 번호가 낮은 학생을 우선적으로 우반에 편성)

 정보
 - n : 학급 내 학생 총 수 (100 이하, 1부터 시작)
 - student[] : 득점을 기록한 학생의 번호를 나열한 배열 (길이가 10이상 3000이하, i번 학생의 득점 기록)
 - point[] : 해당 득점 기록의 점수를 나열한 배열 (student와 길이가 같음, 1~10)
 - return int : 우열반의 편성이 변경되는 횟수

 풀이
 - 우선순위 큐에 학생 번호와 점수를 담는다.
 - 이때, 우반은 학생 점수가 낮은 것이 우선순위이다.
 - 이때, 열반은 학생 점수가 높은 것이 우선순위이다.
 - 우/열반을 담은 우선순위 큐에 현재 값을 꺼내 비교한다.
 - 같다면, 학생 번호를 기준으로 비교해 번호가 낮은 학생이 우반에 편성된다.
 - 다르다면, 더 큰 점수를 가진 학생이 우반으로 편성되고, 낮은 학생은 열반으로 이동한다.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

	private static final Map<Integer, Student> highMap = new HashMap<>();
	private static final Map<Integer, Student> lowMap = new HashMap<>();

	private static final Queue<Student> high = new PriorityQueue<>((o1, o2) -> {
		if (o1.score() == o2.score()) {
			return o2.number() - o1.number();
		}

		return o1.score() - o2.score();
	});

	private static final Queue<Student> low = new PriorityQueue<>((o1, o2) -> {
		if (o1.score() == o2.score()) {
			return o1.number() - o2.number();
		}

		return o2.score() - o1.score();
	});

	public static int solution(int n, int[] student, int[] point) {
		int answer = 0;

		init(n, student, point);

		for (int i = 0; i < n; i++) {
			int cs = student[i];
			int cp = point[i];

			if (highMap.containsKey(cs)) {
				Student current = highMap.get(cs);
				current.sum(cp);
			}

			Student current = lowMap.get(cs);
			current.sum(cp);

			Student ch = high.peek();
			Student cl = low.peek();

			if (check(ch, cl)) {
				answer += 1;

				high.poll();
				low.poll();
				high.add(cl);
				low.add(ch);
			}
		}

		System.out.println(high);
		System.out.println(low);

		return answer;
	}

	private static boolean check(Student ch, Student cl) {
		if (ch.score() < cl.score()) {
			return true;
		}

		if (ch.score() == cl.score() && ch.number() > cl.number()) {
			return true;
		}

		return false;
	}

	private static void init(int n, int[] student, int[] point) {
		int mid = n / 2;

		for (int i = 1; i <= mid; i++) {
			Student s = new Student(i, 0);
			high.add(s);
			highMap.put(i, s);
		}

		for (int i = mid + 1; i <= n; i++) {
			Student s = new Student(i, 0);
			low.add(s);
			lowMap.put(i, s);
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] {6, 1, 4, 2, 5, 1, 3, 3, 1, 6, 5};
		int[] b = new int[] {3, 2, 5, 3, 4, 2, 4, 2, 3, 2, 2};

		solution(6, a, b);
	}

	private static class Student {
		private int number;
		private int score;

		public Student(int number, int score) {
			this.number = number;
			this.score = score;
		}

		public int number() {
			return this.number;
		}

		public int score() {
			return this.score;
		}

		public void sum(int score) {
			this.score += score;
		}

		@Override
		public String toString() {
			return number + ":" + score;
		}
	}
}
