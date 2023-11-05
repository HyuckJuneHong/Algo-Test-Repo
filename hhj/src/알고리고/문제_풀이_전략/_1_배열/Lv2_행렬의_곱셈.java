package src.알고리고.문제_풀이_전략._1_배열;

/**
 * [1, 4], [3, 3]      [00][01]    [00][01]
 * [3, 2], [3, 3]      [10][11]    [10][11]
 * [4, 1]              [20][21]
 * <p>
 * [3][2] * [2][2] = [3][2]
 * <p>
 * [1*3 + 4*3][1*3 + 4*3]
 * [3*3 + 2*3][3*3 + 2*3]
 * [3*3 + 2*3][3*3 + 2*3]
 * <p>
 * a[0][0] * b[0][0] + a[0][1] * b[1][0] / a[0][0] * b[0][1] + a[0][1] * b[1][1]
 * a[1][0] * b[0][0] + a[1][1] * b[1][0] / a[1][0] * b[0][1] + a[1][1] * b[1][1]
 */
public class Lv2_행렬의_곱셈 {

	public int[][] solution(int[][] arr1, int[][] arr2) {
		int n = arr1.length;
		int m = arr1[0].length;
		int k = arr2[0].length;
		int[][] answer = new int[n][k];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				for (int l = 0; l < m; l++) {
					answer[i][j] += arr1[i][l] * arr2[l][j];
				}
			}
		}

		return answer;
	}
}
