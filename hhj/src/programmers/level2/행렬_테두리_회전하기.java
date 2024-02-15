package src.programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class 행렬_테두리_회전하기 {

	public int[] solution(int rows, int columns, int[][] queries) {
		List<Integer> answer = new ArrayList<>();
		int[][] arr = init(rows, columns);

		for (int i = 0; i < queries.length; i++) {
			int min = 10000;
			int[] query = queries[i];
			int y1 = query[0] - 1;
			int x1 = query[1] - 1;
			int y2 = query[2] - 1;
			int x2 = query[3] - 1;
			int temp = arr[y1][x1];
			min = Math.min(min, temp);

			// 위로
			for (int y = y1; y < y2; y++) {
				arr[y][x1] = arr[y + 1][x1];
				min = Math.min(min, arr[y][x1]);
			}

			// 왼쪽으로
			for (int x = x1; x < x2; x++) {
				arr[y2][x] = arr[y2][x + 1];
				min = Math.min(min, arr[y2][x]);
			}

			// 아래로
			for (int y = y2; y > y1; y--) {
				arr[y][x2] = arr[y - 1][x2];
				min = Math.min(min, arr[y][x2]);
			}

			// 오른쪽으로
			for (int x = x2; x > x1 + 1; x--) {
				arr[y1][x] = arr[y1][x - 1];
				min = Math.min(min, arr[y1][x]);
			}

			arr[y1][x1 + 1] = temp;
			answer.add(min + 1);
		}

		return answer.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}

	private int[][] init(int rows, int columns) {
		int[][] arr = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				arr[i][j] = i * columns + j;
			}
		}

		return arr;
	}
}
