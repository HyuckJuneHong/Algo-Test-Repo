package src.프로그래머스_코딩_테스트_문제_풀이_전략._5장;

import java.util.HashMap;
import java.util.Map;

public class 모음사전 {
    private static final int SIZE = 5;
    private static final String[] WORDS = {"A", "E", "I", "O", "U"};
    private static final Map<String, Integer> words = new HashMap<>();

    public static int solution(String word) {
        for (int i = 0; i < SIZE; i++) {
            dfs(word, WORDS[i]);
        }

        return words.get(word);
    }

    public static void dfs(String word, String sum) {
        if (sum.length() > SIZE) {
            return;
        }

        if (!words.containsKey(word)) {
            words.put(sum, words.size() + 1);
        } else {
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            dfs(word, sum + WORDS[i]);
        }
    }
}
