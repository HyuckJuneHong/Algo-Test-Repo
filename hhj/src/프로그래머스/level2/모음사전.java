package src.프로그래머스.level2;

import java.util.HashMap;
import java.util.Map;

public class 모음사전 {
    private static final int SIZE = 5;
    private static final String[] WORDS = {"A", "E", "I", "O", "U"};
    private static final Map<String, Integer> words = new HashMap<>();

    public static int solution(String word) {
        for (int i = 0; i < SIZE; i++) {
            dfs(WORDS[i]);
        }

        return words.get(word);
    }

    private static void dfs(String word) {
        if (word.length() > SIZE) {
            return;
        }

        if (!words.containsKey(word)) {
            words.put(word, words.size() + 1);
        }

        for (int i = 0; i < SIZE; i++) {
            dfs(word + WORDS[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
        System.out.println(solution("I"));
        System.out.println(solution("EIO"));
    }
}
