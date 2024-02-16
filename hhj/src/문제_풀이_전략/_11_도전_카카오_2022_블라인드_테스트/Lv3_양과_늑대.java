package src.문제_풀이_전략._11_도전_카카오_2022_블라인드_테스트;

/*
info[] : 각 노드에 있는 양/늑대에 대한 정보가 담긴 정수 배열 (len=2~17)
edges[][] : 2진 트리의 각 노드들의 연결 관계를 담은 정수 배열 (len=info.len-1)
return int : 문제에 제시된 조건에 따라 각 노드를 방문하면서 모을 수 있는 양의 최대 마릿수

1. 0시작
2. 0에서 갈 수 있는 곳 n개
3. 각각 노드의 최댓 갯수 업데이트
*/
public class Lv3_양과_늑대 {

	static int answer = 0;

	public int solution(int[] info, int[][] edges) {
		dfs(info, edges, 0, 0, 0, new boolean[info.length]);

		return answer;
	}

	private static void dfs(int[] info, int[][] edges, int current, int sheep, int wolf, boolean[] visited) {
		visited[current] = true;

		if (info[current] == 0) {
			sheep += 1;
			answer = Math.max(answer, sheep);
		} else {
			wolf += 1;
		}

		if (sheep <= wolf) {
			return;
		}

		for (int[] edge : edges) {
			int c = edge[0];
			int n = edge[1];

			if (visited[c] && !visited[n]) {
				dfs(info, edges, n, sheep, wolf, visited.clone());
			}
		}
	}
}
