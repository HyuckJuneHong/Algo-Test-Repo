package src.프로그래머스.level2;

public class 마법의_엘리베이터 {
	public int solution(int storey) {
		int answer = dfs(storey, 0);

		return answer;
	}

	private int dfs(int storey, int count) {
		if (storey == 0) {
			return count;
		}

		int x = storey % 10;

		if (x > 5 || x == 5 && (storey / 10) % 10 >= 5) {
			x = 10 - x;
			storey += 10;
		}

		return dfs(storey / 10, count + x);
	}
}
