package src.알고리고.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 뒤에_있는_큰수_찾기 {

    // 1_000_000 * 1_000_000 -> 불가능
    // DP로 풀어보자! -> 실패.. 시간초과...
    // Stack?
    public int[] solution(int[] numbers) {
        Deque<Integer> index = new ArrayDeque<>();
        index.push(0);

        for (int i = 1; i < numbers.length; i++) {

            while (!index.isEmpty() && numbers[index.peek()] < numbers[i]) {
                numbers[index.pop()] = numbers[i];
            }

            index.push(i);
        }

        while (!index.isEmpty()) {
            numbers[index.pop()] = -1;
        }

        return numbers;
    }
}
