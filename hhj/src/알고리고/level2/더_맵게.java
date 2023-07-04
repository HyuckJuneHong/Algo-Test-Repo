package src.알고리고.level2;

import java.util.PriorityQueue;

public class 더_맵게 {
    public static int solution(int[] scoville,
                               int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;

        for (int s : scoville) {
            pq.offer(s);
        }

        while (pq.peek() < K) {

            if (pq.size() < 2) {
                return -1;
            }

            int first = pq.poll();
            int second = pq.poll();

            pq.offer(first + (second * 2));
            count++;
        }

        return count;
    }
}
