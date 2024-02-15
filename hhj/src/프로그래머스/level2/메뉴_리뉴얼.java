package src.프로그래머스.level2;

import java.util.*;

public class 메뉴_리뉴얼 {
    static Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        orders = init(orders);

        for (int i = 0; i < course.length; i++) {
            int max = 0;
            map.clear();

            for (int j = 0; j < orders.length; j++) {
                String order = orders[j];
                int count = course[i];

                if (order.length() >= count) {
                    combi(orders[j], count, new StringBuilder(), 0);
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (max >= 2 && max == entry.getValue()) {
                    answer.add(entry.getKey());
                }
            }
        }

        return answer.stream()
                .sorted()
                .toArray(String[]::new);
    }

    private void combi(String order, int count, StringBuilder sum, int depth) {
        if (sum.length() == count) {
            map.put(sum.toString(), map.getOrDefault(sum.toString(), 0) + 1);
            return;
        }

        for (int i = depth; i < order.length(); i++) {
            sum.append(order.charAt(i));
            combi(order, count, sum, i + 1);
            sum.delete(sum.length() - 1, sum.length());
        }
    }

    private String[] init(String[] orders) {
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        return orders;
    }
}
