package src.프로그래머스.level2;

import java.util.PriorityQueue;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        PriorityQueue<String> dq = new PriorityQueue<>(
                (o1, o2) -> Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2));

        for (int number : numbers) {
            dq.offer(String.valueOf(number));
        }

        while (!dq.isEmpty()) {
            sb.append(dq.poll());
        }

        answer = sb.toString();

        return answer.charAt(0) == '0' ? "0" : answer;
    }
}
