package src.인프런.그리디;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _4_PriorityQueue_프림_최소스패닝트리 {

	static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

	static boolean[] visit;

	public static void main(String[] args) {
		int n = 0;
		int m = 0;

		visit = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int a = 0;
			int b = 0;
			int c = 0;

			graph.get(a).add(new Edge(b, c));
			graph.get(b).add(new Edge(a, c));
		}

		int answer = 0;

		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
		priorityQueue.offer(new Edge(1, 0));

		while (!priorityQueue.isEmpty()) {

			Edge temp = priorityQueue.poll();

			int endV = temp.v;

			if (!visit[endV]) {
				visit[endV] = true;

				answer += temp.cost;

				for (Edge edge : graph.get(endV)) {
					if (!visit[edge.v])
						priorityQueue.offer(new Edge(edge.v, edge.cost));
				}
			}
		}

		System.out.println(answer);
	}

	public static class Edge implements Comparable<Edge> {

		int v;
		int cost;

		public Edge(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {

			return this.cost - o.cost;
		}
	}
}
