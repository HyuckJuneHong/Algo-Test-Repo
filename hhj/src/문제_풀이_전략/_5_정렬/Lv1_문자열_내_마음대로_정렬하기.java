package src.문제_풀이_전략._5_정렬;

import java.util.ArrayList;
import java.util.List;

public class Lv1_문자열_내_마음대로_정렬하기 {

	public static String[] solution(String[] strings, int n) {
		List<Word> answer = new ArrayList<>();

		for (String s : strings) {
			answer.add(new Word(s.charAt(n), s));
		}

		return answer.stream()
			.sorted()
			.map(w -> w.word)
			.toArray(String[]::new);
	}

	public static class Word implements Comparable<Word> {

		char n;
		String word;

		public Word(char n, String word) {
			this.n = n;
			this.word = word;
		}

		@Override
		public int compareTo(Word o) {
			if (this.n == o.n) {
				return this.word.compareTo(o.word);
			}

			return this.n - o.n;
		}
	}
}
