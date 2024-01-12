package src.알고리고.문제_풀이_전략._9_트리_유니온파인드;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 n: 섬의 갯수 (1~100)
 costs[][]: 섬 사이에 다리를 건설하는 비용
 - len = (n - 1) * n / 2
 - [i][0], [i][1] : 다리가 연결되는 두 섬의 번호
 - [i][2] : 두 섬을 연결하는 다리를 건설할 때 드는 비용
 return: 최소의 비용으로 모든 섬이 서로 통해 가능하도록 만들 때 필요한 최소 비용

 1. Edge를 나타낼 클래스를 생성하고 해당 Edge를 비용을 기준으로 오름차순 정렬한다.
 2. 정렬된 Edge를 기준으로 트리를 생성하면서 비용을 계산한다.
 */
public class Lv3_섬_연결하기_최소신장트리 {

	public int solution(int n, int[][] costs) {
		int answer = 0;
		Node[] tree = new Node[n];
		List<Edge> edges = Arrays.stream(costs)
			.map(cost -> new Edge(cost[0], cost[1], cost[2]))
			.sorted()
			.collect(Collectors.toList());

		for (int i = 0; i < n; i++) {
			tree[i] = new Node();
		}

		for (Edge edge : edges) {
			Node n1 = tree[edge.a];
			Node n2 = tree[edge.b];

			if (n1.isConnected(n2)) {
				continue;
			}

			n1.merge(n2);
			answer += edge.cost;
		}

		return answer;
	}

	private static class Edge implements Comparable<Edge> {

		public int a;
		public int b;
		public int cost;

		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return "[a:" + a + ", b:" + b + ", c:" + cost + "]";
		}
	}

	private static class Node {

		public Node parent;
		public int depth;

		public Node() {
			this.parent = null;
			this.depth = 1;
		}

		private Node getRoot() {
			if (this.parent == null) {
				return this;
			}

			return this.parent.getRoot();
		}

		public boolean isConnected(Node o) {
			return this.getRoot() == o.getRoot();
		}

		public void merge(Node o) {
			if (this.isConnected(o)) {
				return;
			}

			Node root1 = this.getRoot();
			Node root2 = o.getRoot();

			if (root1.depth > root2.depth) {
				root2.parent = root1;
			} else if (root1.depth < root2.depth) {
				root1.parent = root2;
			} else {
				root2.parent = root1;
				root1.depth += 1;
			}
		}
	}
}
