package src.알고리고.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _3차_압축 {
    static List<Integer> answer = new ArrayList<>();
    static Map<String, Integer> book = new HashMap<>();
    static int index = 1;

    public static int[] solution(String msg) {
        init();
        findAndAdd(msg);
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void findAndAdd(String msg) {
        msg += " ";

        while (!msg.isBlank()) {
            String w = msg;
            int endPoint = w.length();

            while (true) {
                if (book.containsKey(w)) {
                    answer.add(book.get(w));
                    String c = msg.charAt(endPoint) + "";
                    book.put(w + c, index++);
                    break;
                }

                w = w.substring(0, --endPoint);
            }

            msg = msg.substring(endPoint);
        }
    }

    public static void init() {
        for (char i = 'A'; i <= 'Z'; i++) {
            book.put(i + "", index++);
        }
    }

    public static void main(String[] args) {
        int[] answer = solution("TOBEORNOTTOBEORTOBEORNOT");

        for (int a : answer) {
            System.out.println(a);
        }
    }
}
