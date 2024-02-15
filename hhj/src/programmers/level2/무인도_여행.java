package src.programmers.level2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 무인도_여행 {
	static final int[] DX = {-1, 0, 1, 0};
	static final int[] DY = {0, 1, 0, -1};

	static List<Integer> answer = new ArrayList<>();
	static boolean[][] visited;
	static int[][] map;

	public int[] solution(String[] maps) {
		int n = maps.length;
		int m = maps[0].length();
		init(maps, n, m);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] >= 1 && !visited[i][j]) {
					bfs(n, m, i, j);
				}
			}
		}

		return answer.isEmpty() ? new int[] {-1} : answer.stream()
			.sorted()
			.mapToInt(Integer::intValue)
			.toArray();
	}

	private void bfs(int n, int m, int y, int x) {
		Deque<Point> q = new ArrayDeque<>();
		q.add(new Point(y, x));
		visited[y][x] = true;
		int sum = map[y][x];

		while (!q.isEmpty()) {
			Point current = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = current.y + DY[i];
				int nx = current.x + DX[i];

				if (ny >= 0 && nx >= 0 && ny < n && nx < m && !visited[ny][nx] && map[ny][nx] != -1) {
					visited[ny][nx] = true;
					sum += map[ny][nx];
					q.add(new Point(ny, nx));
				}
			}
		}

		answer.add(sum);
	}

	private void init(String[] maps, int n, int m) {
		visited = new boolean[n][m];
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] mapLine = maps[i].split("");

			for (int j = 0; j < m; j++) {
				String current = mapLine[j];

				if (current.equals("X")) {
					map[i][j] = -1;
					continue;
				}

				map[i][j] = Integer.parseInt(current);
			}
		}
	}

	public static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
