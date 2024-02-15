package src.문제_풀이_전략._10_구현_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 n : 컴퓨터 개수 (1~200)
 computers[][] : 연결에 대한 정보가 담긴 배열 (i, j 연결 -> computers[i][j] == 1)
 return int : 네트워크 개수

 1. 그래프를 돌면서 몇번의 BFS가 실행되는지 확인한다.
 */
public class Lv3_네트워크_BFS {

	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				continue;
			}

			answer += bfs(n, computers, i, visited);
		}

		return answer;
	}

	private int bfs(int n, int[][] computers, int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			int[] computer = computers[current];

			for (int next = 0; next < computer.length; next++) {
				if (current == next || computer[next] == 0 || visited[next]) {
					continue;
				}

				visited[next] = true;
				queue.add(next);
			}
		}

		return 1;
	}
}
