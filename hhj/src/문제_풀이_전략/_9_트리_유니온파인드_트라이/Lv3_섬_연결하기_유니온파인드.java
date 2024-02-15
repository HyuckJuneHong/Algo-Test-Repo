package src.문제_풀이_전략._9_트리_유니온파인드_트라이;

import java.util.Arrays;

/**
 * 1. parent 배열을 생성해 각 인덱스를 정점으로 표현한다.
 * 2. parent의 각 정점은 초기에 자기 자신을 부모로 설정하낟.
 * 3. costs의 비용을 기준으로 오름차순 정렬한다.
 * 4. costs을 순회하면서 다음을 수행한다.
 * - 현재 비용의 출발, 도착을 Find(조회) 한다.
 * - 출발, 도착의 부모가 다르면, 즉 사이클이 형성되지 않으면, Union(합병) 후 비용을 추가한다.
 * - 출발, 도착 부모가 같으면 즉 사이클이 형성되었으면 건너뛴다.
 * 5. 최소 신장 트리 비용을 반환한다.
 */
public class Lv3_섬_연결하기_유니온파인드 {

	static int[] parent;

	public int solution(int n, int[][] costs) {
		int answer = 0;

		parent = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

		for (int[] cost : costs) {
			int a = cost[0];
			int b = cost[1];

			if (find(a) != find(b)) {
				union(a, b);
				answer += cost[2];
			}
		}

		return answer;
	}

	private int find(int index) {
		if (parent[index] == index) {
			return index;
		}

		return find(parent[index]);
	}

	private void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) {
			parent[b] = a;
		} else if (a > b) {
			parent[a] = b;
		}
	}
}
