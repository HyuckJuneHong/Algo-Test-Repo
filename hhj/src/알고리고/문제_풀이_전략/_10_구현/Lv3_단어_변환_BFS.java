package src.알고리고.문제_풀이_전략._10_구현;

import java.util.LinkedList;
import java.util.Queue;

/**
 begin : 처음 주어지는 단어 (len=3~10)
 target : begin으로 시작해 바꾸려는 단어 (len=3~10)
 words[] : 단어의 집합 (len=3~50, 중복 X)
 return int : 최소 몇 단계 과정을 거쳐 begin을 target으로 바꿀 수 있는 지 최소 횟수 (변환할 수 없으면 0)

 1. 완탐으로 진행해도 문제가 없을 갯수 (BFS)
 2. 종료 조건 : begin == target
 */
public class Lv3_단어_변환_BFS {

	public int solution(String begin, String target, String[] words) {
		return bfs(begin, target, words);
	}

	private static class Word {

		String word;
		int count;

		public Word(String word, int count) {
			this.word = word;
			this.count = count;
		}
	}

	private int bfs(String begin, String target, String[] words) {
		Queue<Word> queue = new LinkedList<>();
		boolean[] visited = new boolean[words.length];

		queue.add(new Word(begin, 0));

		while (!queue.isEmpty()) {
			Word current = queue.poll();

			if (target.equals(current.word)) {
				return current.count;
			}

			for (int i = 0; i < words.length; i++) {
				if (visited[i] || !isConversion(current.word, words[i])) {
					continue;
				}

				queue.add(new Word(words[i], current.count + 1));
				visited[i] = true;
			}
		}

		return 0;
	}

	private boolean isConversion(String current, String next) {
		int count = 0;

		for (int i = 0; i < current.length(); i++) {
			char bc = current.charAt(i);
			char nc = next.charAt(i);

			if (bc != nc) {
				count++;
			}

			if (count >= 2) {
				return false;
			}
		}

		return count == 1;
	}
}
