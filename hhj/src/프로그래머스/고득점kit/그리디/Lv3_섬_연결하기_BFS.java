package src.프로그래머스.고득점kit.그리디;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
n : 섬의 개수 (1~100)
costs[][] : 섬 사이에 다리를 건설하는 비용 (len=(n-1)*n/2 이하, val[i]={섬1, 섬2, 비용})
return int : 최소 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용
*/
public class Lv3_섬_연결하기_BFS {

	static int answer = 0;
	static List<List<Point>> graph = new ArrayList<>();

	public int solution(int n, int[][] costs) {
		init(n, costs);
		bfs(n);

		return answer;
	}

	private void bfs(int n) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n];

		pq.add(new Point(0, 0));

		while (!pq.isEmpty()) {
			Point current = pq.poll();
			int cn = current.node;
			int cc = current.cost;

			if (visited[cn]) {
				continue;
			}

			visited[cn] = true;
			answer += cc;

			for (Point point : graph.get(cn)) {
				int nn = point.node;
				int nc = point.cost;

				if (visited[nn]) {
					continue;
				}

				pq.add(new Point(nn, nc));
			}
		}
	}

	private void init(int n, int[][] costs) {
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] cost : costs) {
			int a = cost[0];
			int b = cost[1];
			int c = cost[2];

			graph.get(a).add(new Point(b, c));
			graph.get(b).add(new Point(a, c));
		}
	}

	private static class Point implements Comparable<Point> {

		int node;
		int cost;

		public Point(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return this.cost - o.cost;
		}
	}
}
