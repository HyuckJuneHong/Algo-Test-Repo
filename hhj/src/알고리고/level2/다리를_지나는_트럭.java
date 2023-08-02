package src.알고리고.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> bridge = new ArrayDeque<>();
        int currentWeight = 0;
        int answer = 0;
        int index = 0;

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (index < truck_weights.length) {
            currentWeight -= bridge.poll();
            answer += 1;

            int current = truck_weights[index];

            if (currentWeight + current <= weight) {
                bridge.offer(current);
                currentWeight += current;
                index++;
            } else {
                bridge.offer(0);
            }
        }

        return answer + bridge_length;
    }
}
