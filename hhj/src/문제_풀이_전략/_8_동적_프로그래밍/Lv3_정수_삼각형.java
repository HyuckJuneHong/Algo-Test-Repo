package src.문제_풀이_전략._8_동적_프로그래밍;

/**
 triangle : 삼각형 정보가 담긴 배열 (yLen=1~500, value=0~9_999)
 return : 거쳐간 숫자의 최댓값

 1. 뒤에서부터 두 값 중 큰 값을 윗값에 더한다.
 2. 끝까지 반복한다.
 3. 가장 맨위에 남은 값을 반환한다.
 */
public class Lv3_정수_삼각형 {

	public int solution(int[][] triangle) {
		for (int i = triangle.length - 1; i >= 1; i--) {
			for (int j = 0; j < triangle[i].length - 1; j++) {
				triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);
			}
		}

		return triangle[0][0];
	}
}
