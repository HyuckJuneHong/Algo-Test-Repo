package src.알고리고.문제_풀이_전략._1_배열;

/**
 * 문제풀이
 * 1. 크기가 n인 배열 생성
 * 2. 아래 방향으로 순서대로 숫자를 채운다. (y값만 증가 )
 * 3. 오른쪽 방향으로 순서대로 숫자를 채운다. (x값만 증가)
 * 4. 대각선 위 방향으로 순서대로 숫자를 채운다. (y, x값 감소)
 * 5. 2~4 반복
 */
public class Lv2_삼각_달팽이_방향에_중복_코드 {

	public int[] solution(int n) {
		int[][] arr = new int[n][n];
		int y = 0;
		int x = 0;
		int value = 1;

		while (true) {
			// y 증가
			while (true) {
				arr[y][x] = value++;

				if (y + 1 == n || arr[y + 1][x] != 0) {
					break;
				}

				y++;
			}

			if (x + 1 == n || arr[y][x + 1] != 0) {
				break;
			}

			x++;

			// x 증가
			while (true) {
				arr[y][x] = value++;

				if (x + 1 == n || arr[y][x + 1] != 0) {
					break;
				}

				x++;
			}

			if (arr[y - 1][x - 1] != 0) {
				break;
			}

			y--;
			x--;

			// x, y 감소
			while (true) {
				arr[y][x] = value++;

				if (arr[y - 1][x - 1] != 0) {
					break;
				}

				y--;
				x--;
			}

			if (y + 1 == n || arr[y + 1][x] != 0) {
				break;
			}

			y++;
		}

		int[] answer = new int[value];
		int index = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				answer[index++] = arr[i][j];
			}
		}

		return answer;
	}
}
