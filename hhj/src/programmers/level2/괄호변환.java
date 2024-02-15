package src.programmers.level2;

public class 괄호변환 {
	public String solution(String p) {
		int lt = 0, rt = 0;
		int index = 0;

		if (p.isBlank()) {
			return p;
		}

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				lt++;
			} else {
				rt++;
			}

			if (lt == rt) {
				index = i + 1;
				break;
			}
		}

		StringBuilder u = new StringBuilder(p.substring(0, index));
		StringBuilder v = new StringBuilder(p.substring(index));

		if (isCorrect(u.toString())) {
			return u.append(solution(v.toString())).toString();
		}

		StringBuilder sb = new StringBuilder("(");
		sb.append(solution(v.toString()));
		sb.append(")");
		String reverse = getReverse(u.substring(1, u.length() - 1));
		sb.append(reverse);

		return sb.toString();
	}

	private boolean isCorrect(String p) {
		int result = 0;

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				result++;
			} else if (result > 0) {
				result--;
			} else {
				return false;
			}
		}

		return result == 0;
	}

	private String getReverse(String p) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				sb.append(")");
			} else {
				sb.append("(");
			}
		}

		return sb.toString();
	}
}
