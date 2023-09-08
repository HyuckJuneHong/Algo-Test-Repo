package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 문제
 - N개의 컴퓨터 있음
 - M개의 통신 회선 있음
 - 각 컴퓨터 번호 붙음 (1~N)
 - 서로 양방향임
 - 통신 회선만을 이용해 연결 -> 같은 컴포넌트
 - 가장 밀도가 높은 컴포넌트 조사
 - 밀도 = 통신 회선 갯수 / 컴퓨터 수

 입력
 - N : 컴퓨터 개수 (2~100_000)
 - M : 통신 회선 갯수 (1~200_000)

 출력 조건
 1. 가장 밀도 높은 컴포넌트 출력
 2. 1을 만족하는 것이 여러개면 가장 작은 컴포넌트 출력
 3. 2를 만족하는 컴포넌트 여러개면 더 작은 컴퓨터가 있는 컴포넌트 출력
 */
public class _17일차 {

	static List<Integer> answer;
	static List<List<Integer>> graph;
	static boolean[] visited;
	static double maxSize = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[][] computer = new int[M][2];

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			computer[i][0] = Integer.parseInt(input[0]) - 1;
			computer[i][1] = Integer.parseInt(input[1]) - 1;
		}

		String answer = getComponent(N, computer);
		System.out.print(answer);
	}

	private static String getComponent(int N, int[][] computer) {
		StringBuilder sb = new StringBuilder();
		init(N, computer);

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				bfs(i);
			}
		}

		for (int number : answer) {
			sb.append(number + 1)
				.append(" ");
		}

		return sb.toString();
	}

	private static void bfs(int a) {
		List<Integer> component = new ArrayList<>();
		Deque<Integer> q = new ArrayDeque();
		double edge = 0;
		double density;
		component.add(a);
		visited[a] = true;
		q.add(a);

		while (!q.isEmpty()) {
			int start = q.poll();

			for (int end : graph.get(start)) {
				if (!visited[end]) {
					q.add(end);
					component.add(end);
					visited[end] = true;
				}

				edge++;
			}
		}

		if (edge == 0) {
			return;
		}

		density = edge / component.size();

		if (Double.compare(maxSize, density) > 0) {
			return;
		}

		Collections.sort(component);

		if (Double.compare(maxSize, density) < 0) {
			maxSize = density;
			answer = component;
			return;
		}

		if (answer.size() > component.size()) {
			answer = component;
			return;
		}

		if (answer.get(0) > component.get(0)) {
			answer = component;
		}
	}

	private static void init(int N, int[][] computer) {
		visited = new boolean[N];
		graph = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] com : computer) {
			int a = com[0];
			int b = com[1];
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
	}
}
