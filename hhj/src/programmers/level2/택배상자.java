package src.programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 택배상자 {
    public int solution(int[] order) {
        Deque<Integer> sub = new ArrayDeque<>();
        int idx = 0;
        int answer = 0;

        for (int i = 1; i <= order.length; i++) {
            while (!sub.isEmpty() && sub.peek() == order[idx]) {
                idx++;
                sub.pop();
                answer++;
            }

            if (order[idx] == i) {
                idx++;
                answer++;
            } else {
                sub.push(i);
            }
        }

        while (!sub.isEmpty() && sub.peek() == order[idx]) {
            idx++;
            sub.pop();
            answer++;
        }

        return answer;
    }
}
