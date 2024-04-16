package src.프로그래머스.PCCP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class 모의고사1_1번 {
	public String solution(String input_string) {
		// 1단계: 문자열 압축
		List<Character> compression = compressString(input_string);

		// 2단계 : 외톨이 찾기
		List<Character> loners = findLoner(compression);

		// 3단계 : 정답 출력
		return printAnswer(loners);
	}

	private List<Character> compressString(String inputString) {
		char current = inputString.charAt(0);

		List<Character> list = new ArrayList<>();
		list.add(current);

		for (int i = 1; i < inputString.length(); i++) {
			char next = inputString.charAt(i);

			if (current == next) {
				continue;
			}

			current = next;
			list.add(next);
		}

		return list;
	}

	private List<Character> findLoner(List<Character> compression) {
		List<Character> loners = new ArrayList<>();
		Set<Character> words = new HashSet<>();

		for (char c : compression) {
			if (words.contains(c)) {
				loners.add(c);
				continue;
			}

			words.add(c);
		}

		return loners;
	}

	private String printAnswer(List<Character> loners) {
		String answer = loners.stream()
			.distinct()
			.sorted()
			.map(String::valueOf)
			.collect(Collectors.joining());

		return answer.isEmpty() ? "N" : answer;
	}
}
