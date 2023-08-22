package src.알고리고.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 두_큐합_같게_만들기 {
    public int solution(int[] queue1, int[] queue2) {
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        long sum1 = 0;
        long sum2 = 0;
        int answer = 0;
        int max = queue1.length * 3;

        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        while (sum1 != sum2) {
            if (max < answer) {
                return -1;
            }

            if (sum1 > sum2) {
                int insert = q1.pop();
                q2.add(insert);
                sum1 -= insert;
                sum2 += insert;
            } else {
                int insert = q2.pop();
                q1.add(insert);
                sum2 -= insert;
                sum1 += insert;
            }

            answer++;
        }

        return answer;
    }
}

