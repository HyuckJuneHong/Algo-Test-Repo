package src.programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 소수_찾기 {
    static Set<Integer> answer = new HashSet<>();
    static char[] arr;
    static boolean[] visited;

    public int solution(String numbers) {
        arr = new char[numbers.length()];
        visited = new boolean[arr.length];

        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }

        dfs("", 0);

        return answer.size();
    }

    private void dfs(String sum, int depth) {
        if (!sum.isBlank()) {
            int number = Integer.parseInt(sum);

            if (isPrime(number)) {
                answer.add(number);
            }
        }

        if (depth == arr.length) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            dfs(sum + arr[i], depth + 1);
            visited[i] = false;
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        int mid = (int) Math.sqrt(number);

        for (int i = 2; i <= mid; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
