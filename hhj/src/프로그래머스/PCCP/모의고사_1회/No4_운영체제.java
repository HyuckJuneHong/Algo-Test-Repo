package src.프로그래머스.PCCP.모의고사_1회;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class No4_운영체제 {

	private final long[] answer = new long[11];
	private final Queue<Program> readyQueue = new PriorityQueue<>();

	public long[] solution(int[][] program) {
		int currentTime = 0;

		final Queue<Program> programs = Arrays.stream(program)
			.map(p -> new Program(p[0], p[1], p[2]))
			.sorted(Comparator.comparingInt(Program::createdAt))
			.collect(Collectors.toCollection(LinkedList::new));

		while (!readyQueue.isEmpty() || !programs.isEmpty()) {
			while (!programs.isEmpty() && programs.peek().createdAt() <= currentTime) {
				readyQueue.add(programs.poll());
			}

			if (readyQueue.isEmpty() && !programs.isEmpty()) {
				currentTime = programs.peek().createdAt();
				continue;
			}

			final Program current = readyQueue.poll();
			answer[current.score()] += currentTime - current.createdAt();
			currentTime += current.executedTime();
		}

		answer[0] = currentTime;

		return answer;
	}

	private class Program implements Comparable<Program> {
		private final int score;
		private final int createdAt;
		private final int executedTime;

		public Program(int score, int createdAt, int executedTime) {
			this.score = score;
			this.createdAt = createdAt;
			this.executedTime = executedTime;
		}

		@Override
		public int compareTo(Program o) {
			if (this.score == o.score) {
				return this.createdAt - o.createdAt;
			}

			return this.score - o.score;
		}

		@Override
		public String toString() {
			return this.score + "," + this.createdAt + "," + this.executedTime;
		}

		public int score() {
			return this.score;
		}

		public int createdAt() {
			return this.createdAt;
		}

		public int executedTime() {
			return this.executedTime;
		}
	}
}
