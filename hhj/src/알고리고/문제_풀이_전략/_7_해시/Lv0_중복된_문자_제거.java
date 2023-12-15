package src.알고리고.문제_풀이_전략._7_해시;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Lv0_중복된_문자_제거 {

	/**
	 * @param my_string
	 * @return answer.stream().collect(Collectors.joining ());
	 */
	public String solution(String my_string) {
		String[] myString = my_string.split("");
		Set<String> answer = new LinkedHashSet<>(Arrays.asList(myString));

		return String.join("", answer);
	}
}
