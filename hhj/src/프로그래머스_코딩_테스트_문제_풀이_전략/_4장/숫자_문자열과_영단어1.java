package src.프로그래머스_코딩_테스트_문제_풀이_전략._4장;

import java.util.HashMap;
import java.util.Map;

public class 숫자_문자열과_영단어1 {
    static Map<String, Integer> map = new HashMap<>();

    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        init();

        for (char c : s.toCharArray()) {
            sb.append(String.valueOf(c));

            if (map.containsKey(sb.toString())) {
                answer.append(map.get(sb.toString()));
                sb = new StringBuilder();
            }
        }

        return Integer.parseInt(answer.toString());
    }

    private void init() {
        map.put("0", 0);
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);

        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
    }
}
