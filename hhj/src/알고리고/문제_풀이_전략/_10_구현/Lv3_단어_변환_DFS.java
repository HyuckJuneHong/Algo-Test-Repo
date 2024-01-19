package src.알고리고.문제_풀이_전략._10_구현;

/**
 begin : 처음 주어지는 단어 (len=3~10)
 target : begin으로 시작해 바꾸려는 단어 (len=3~10)
 words[] : 단어의 집합 (len=3~50, 중복 X)
 return int : 최소 몇 단계 과정을 거쳐 begin을 target으로 바꿀 수 있는 지 최소 횟수 (변환할 수 없으면 0)

 1. 완탐으로 진행해도 문제가 없을 갯수 (DFS)
 2. 종료 조건 : begin == target
 */
public class Lv3_단어_변환_DFS {

	static int answer = 0;
	static boolean[] visited;

	public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		dfs(begin, target, words, 0);

		return answer;
	}

	private void dfs(String begin, String target, String[] words, int depth) {
		if (begin.equals(target)) {
			answer = depth;
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (visited[i] || !isConversion(begin, words[i])) {
				continue;
			}

			visited[i] = true;
			dfs(words[i], target, words, depth + 1);
			visited[i] = false;
		}
	}

	private boolean isConversion(String begin, String next) {
		int count = 0;

		for (int i = 0; i < next.length(); i++) {
			char bc = begin.charAt(i);
			char nc = next.charAt(i);

			if (bc != nc) {
				count++;
			}

			if (count == 2) {
				return false;
			}
		}

		return true;
	}
}
