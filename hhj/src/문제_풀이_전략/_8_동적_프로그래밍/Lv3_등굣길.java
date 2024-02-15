package src.문제_풀이_전략._8_동적_프로그래밍;

/**
 m, n : 격자 크기(집=[1,1], 학교=[m, n], 격자크기=1~100)
 puddles : 물이 잠긴 지역의 좌표를 담은 2차원 배열 (물이 잠긴 지역 갯수 = 0~10)
 return : 오른쪽, 아래로만 움직여서 집에서 학교까지 갈 수 있는 최단 경로 개수를 1_000_000_007로 나눈 나머지

 1. 현재 위치가 잠긴 지역이 아니라면 이전 위치인 왼쪽과 위의 값을 더해서 다음 위치에 등록한다.
 2. 오른쪽과 아래로만 이동 시, 무조건 최단 경로가 나오기 때문에, 마지막 최종값이 최단 경로 갯수가 된다.
 */
public class Lv3_등굣길 {

	public int solution(int m, int n, int[][] puddles) {
		int[][] map = new int[m + 1][n + 1];

		map[1][1] = 1;

		for (int[] puddle : puddles) {
			int y = puddle[0];
			int x = puddle[1];

			map[y][x] = -1;
		}

		for (int y = 1; y <= m; y++) {
			for (int x = 1; x <= n; x++) {
				if (map[y][x] == -1) {
					continue;
				}

				if (y == 1 && x == 1) {
					continue;
				}

				int top = map[y - 1][x] == -1 ? 0 : map[y - 1][x];
				int left = map[y][x - 1] == -1 ? 0 : map[y][x - 1];

				map[y][x] = (top + left) % 1_000_000_007;
			}
		}

		return map[m][n];
	}
}
