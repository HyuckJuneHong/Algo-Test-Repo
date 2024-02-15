package src.프로그래머스.level2;

import java.util.*;

public class 후보키 {

    static List<String> answer;
    static List<String> list;
    static boolean[] visited;
    static int n, m;

    public int solution(String[][] relation) {
        init(relation);

        for (int i = 0; i < m; i++) {
            createCombination(0, i + 1);

            for (String data : list) {
                unique(relation, data);
            }

            list.clear();
        }

        return answer.size();
    }

    public void unique(String[][] relation, String data) {
        String[] temp = data.split("");
        int[] arr = Arrays.stream(temp)
                .mapToInt(Integer::parseInt)
                .toArray();

        //유일성
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j : arr) {
                sb.append(relation[i][j]);
            }

            if (set.contains(sb.toString())) {
                return;
            }

            set.add(sb.toString());
        }

        //최소성
        for (String ans : answer) {
            int count = 0;

            for (char c : data.toCharArray()) {
                if (ans.contains(String.valueOf(c))) {
                    count++;
                }
            }

            if (count == ans.length()) {
                return;
            }
        }

        answer.add(data);
    }

    // 조합수
    public void createCombination(int start, int end) {
        if (end == 0) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < m; i++) {
                if (visited[i]) {
                    sb.append(i);
                }
            }

            list.add(sb.toString());

            return;
        }

        for (int i = start; i < m; i++) {
            if (!visited[i]) {
                visited[i] = true;
                createCombination(i + 1, end - 1);
                visited[i] = false;
            }
        }
    }

    // 초기화
    public void init(String[][] relation) {
        answer = new ArrayList<>();
        list = new ArrayList<>();
        n = relation.length;
        m = relation[0].length;
        visited = new boolean[m];
    }
}
