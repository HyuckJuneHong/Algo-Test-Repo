package src.문제_풀이_전략._9_힙_우선순위큐;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 jobs[][] : 각 작업에 대해 [작업 요청 시점, 작업 소요시간]을 담은 2차원 배열 (len=1~500, val[0]=0~1_000, val[1]=1~1_000)
 return : 작업 요청 -> 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리 시 평균 값 (소수점 이하는 버림)

 1. 현재 시점에 소요시간이 짧은 작업을 처리한다.
 - jobs[0][0]==0 인 것 중 가장 짧은 작업 요소를 찾는다. (N)
 2. 이 후 끝난 시점에 쇼요시간이 짧은 작업을 처리한다. 이를 반복한다.
 - jobs[n][0] >= jobs[0][0] + jobs[0][1] 인 것 중 가장 짧은 것을 찾는다.
 - 하지만 모든 작업을 비교해서 소요시간을 비교하기엔, 시간복잡도가 아쉽다.
 - 우선순위 큐를 사용해, 소요시간을 측정하자. (N logN; 정렬 및 반환)

 1. 일단 jobs를 표현할 클래스를 생성한다.
 2. 해당 잡들을 큐에 담아서 관리하자.
 - 큐는 시작 시간을 기준으로 정렬하자.
 3. 현재 큐의 작업이 현재 시각에 처리가 가능하면 우선순위 큐에 담는다.
 - 우선순위 기준은 소요시간이다.
 4. 우선순위 큐에서 현재 값을 꺼내, 누적합을 한다.
 5. 평균을 구해서 반환한다.
 */
public class Lv3_디스크_컨트롤러 {

	public int solution(int[][] jobs) {
		int answer = 0;
		int currentTime = 0;
		Deque<Job> q = new ArrayDeque<>();
		Queue<Job> pq = new PriorityQueue<>();

		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		for (int[] job : jobs) {
			q.add(new Job(job[0], job[1]));
		}

		while (!q.isEmpty() || !pq.isEmpty()) {
			while (!q.isEmpty() && q.peek().start <= currentTime) {
				pq.add(q.poll());
			}

			if (pq.isEmpty()) {
				currentTime += 1;
				continue;
			}

			Job job = pq.poll();
			answer += currentTime + job.time - job.start;
			currentTime += job.time;
		}

		return answer / jobs.length;
	}

	private static class Job implements Comparable<Job> {

		public int start;
		public int time;

		public Job(int start, int time) {
			this.start = start;
			this.time = time;
		}

		@Override
		public int compareTo(Job o) {
			return this.time - o.time;
		}
	}
}
