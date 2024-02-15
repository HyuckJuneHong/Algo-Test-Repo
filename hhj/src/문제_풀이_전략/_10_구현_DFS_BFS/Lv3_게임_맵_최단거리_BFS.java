package src.문제_풀이_전략._10_구현_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 maps[][] : 게임 맵의 상태 (len=1~100, val=0과 1로 이루어짐, 0은 벽이고 1은 통로)
 return int : 캐릭터가 상대 팀 진영에 도착하기 위해 지나가야 하는 칸의 최소 갯수 단, 불가능할 시 -1 반환

 1. 최단 경로기 때문에, BFS를 사용
 2. Queue에 현재 위치 1,1을 넣는다.
 3. Queue에 이동 가능한 곳을 넣으며 visited로 이동한 곳을 체크한다.
 4. n,m에 도착 시 반환
 */
public class Lv3_게임_맵_최단거리_BFS {

	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {-1, 0, 1, 0};

	public int solution(int[][] maps) {
		Point start = new Point(0, 0, 1);
		Point end = new Point(maps.length - 1, maps[0].length - 1, 1);

		return bfs(maps, start, end);
	}

	private int bfs(int[][] maps, Point start, Point end) {
		boolean[][] visited = new boolean[end.y + 1][end.x + 1];
		Queue<Point> queue = new LinkedList<>();

		queue.add(start);

		while (!queue.isEmpty()) {
			Point current = queue.poll();

			if (current.equals(end)) {
				return current.count;
			}

			for (int i = 0; i < 4; i++) {
				int ny = current.y + dy[i];
				int nx = current.x + dx[i];

				if (ny == -1 || nx == -1 || ny > end.y || nx > end.x || visited[ny][nx] || maps[ny][nx] == 0) {
					continue;
				}

				visited[ny][nx] = true;
				queue.add(new Point(ny, nx, current.count + 1));
			}
		}

		return -1;
	}

	private static class Point {

		int y;
		int x;
		int count;

		public Point(int y, int x, int count) {
			this.y = y;
			this.x = x;
			this.count = count;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Point) {
				Point p = (Point)o;

				return this.y == p.y && this.x == p.x;
			}

			return false;
		}
	}
}
