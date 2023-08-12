package src.프로그래머스_코딩_테스트_문제_풀이_전략.시험_1주_학습_스케줄;

import java.util.HashMap;
import java.util.Map;

public class Lv2_모음_사전 {
    static final String[] WORD = {"A", "E", "I", "O", "U"};

    static Map<String, Integer> words = new HashMap<>();
    static int index = 0;
    static String point = "";

    public static int solution(String word) {
        point = word;

        for (String w : WORD) {
            dfs(w);
        }

        return words.get(word);
    }

    public static void dfs(String word) {

        if (word.length() > 5) {
            return;
        }

        if (!words.containsKey(word)) {
            words.put(word, ++index);

            if (word.equals(point)) {
                return;
            }
        }

        for (String w : WORD) {
            dfs(word + w);
        }
    }
}
