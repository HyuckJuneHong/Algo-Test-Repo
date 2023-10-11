package src.알고리고.level2;

import java.util.ArrayList;
import java.util.List;

public class 혼자_놀기의_달인 {

    static boolean[] visited;

    public int solution(
            int[] cards // 2~100 (중복 없음, i번째 배열 = i + 1번 상자에 담긴 카드에 적힌 숫자를 의미)
    ) {
        int answer = 0;
        int n = cards.length;

        for (int i = 0; i < n; i++) {
            List<Integer> group1 = new ArrayList<>();
            visited = new boolean[n];
            dfs(cards, 0, i, visited, group1);

            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    continue;
                }

                List<Integer> group2 = new ArrayList<>();
                dfs(cards, 0, j, visited.clone(), group2);
                answer = Math.max(answer, group1.get(0) * group2.get(0));
            }
        }

        return answer;
    }

    public void dfs(int[] cards, int depth, int index, boolean[] v, List<Integer> group) {
        if (v[index]) {
            group.add(depth);
            return;
        }

        v[index] = true;
        dfs(cards, depth + 1, cards[index] - 1, v, group);
    }
}
