package src.알고리고.문제_풀이_전략._3_재귀;

import java.util.ArrayList;
import java.util.List;

/**
 문제풀이
 1) 1 ,2 ,3 기둥이 있으니 그에 따른 함수 생성
 2) (n, from, empty, to) -> n개를 from에서 to로
 1) n-1개를 from을 empty로
 2) 1개를 from에서 to로 (이때 return 및 저장)
 3) empty에 있는 n-1개로 다시 시작
 */
public class Lv3_하노이의_탑 {

	static List<int[]> answer = new ArrayList<>();

	public int[][] solution(int n) {
		dfs(n, 1, 2, 3);

		return answer.toArray(int[][]::new);
	}

	public void dfs(int n, int from, int empty, int to) {
		if (n == 1) {
			answer.add(new int[] {from, to});
			return;
		}

		dfs(n - 1, from, to, empty);
		dfs(1, from, empty, to);
		dfs(n - 1, empty, from, to);
	}
}
