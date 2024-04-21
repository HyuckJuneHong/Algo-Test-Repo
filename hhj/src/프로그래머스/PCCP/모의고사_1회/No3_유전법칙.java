package src.프로그래머스.PCCP.모의고사_1회;

import java.util.Arrays;

public class No3_유전법칙 {
	private static final String[] BEANS = {"RR", "Rr", "Rr", "rr"};

	public String[] solution(int[][] queries) {
		return Arrays.stream(queries)
			.map(query -> find(query[0] - 1, query[1] - 1, "Rr"))
			.toArray(String[]::new);
	}

	public String find(int n, int p, String bean) {
		if (!bean.equals("Rr") || n == 0) {
			return bean;
		}

		int pre = (int)Math.pow(4, n - 1);
		int current = p / pre;

		if (current < 4) {
			bean = BEANS[current];
		}

		return find(n - 1, p % pre, bean);
	}
}
