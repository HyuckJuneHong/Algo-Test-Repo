package src.프로그래머스.고득점kit.그리디;

import java.util.Arrays;

/*
n : 섬의 개수 (1~100)
costs[][] : 섬 사이에 다리를 건설하는 비용 (len=(n-1)*n/2 이하, val[i]={섬1, 섬2, 비용})
return int : 최소 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용
*/
public class Lv3_섬_연결하기_유니온파인드 {

	static int[] parent;

	public int solution(int n, int[][] costs) {
		int answer = 0;

		init(n);
		Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

		for (int[] cost : costs) {
			int a = cost[0];
			int b = cost[1];

			if (union(a, b)) {
				answer += cost[2];
			}
		}

		return answer;
	}

	private static boolean union(int node1, int node2) {
		int n1 = find(node1);
		int n2 = find(node2);

		if (n1 == n2) {
			return false;
		}

		if (n1 > n2) {
			parent[n2] = n1;
		} else {
			parent[n1] = n2;
		}

		return true;
	}

	private static int find(int node) {
		if (parent[node] == node) {
			return parent[node];
		}

		return find(parent[node]);
	}

	private static void init(int n) {
		parent = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}
}
