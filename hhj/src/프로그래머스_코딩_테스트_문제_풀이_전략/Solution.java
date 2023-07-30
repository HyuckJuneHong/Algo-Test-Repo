package src.프로그래머스_코딩_테스트_문제_풀이_전략;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    // 1_000_000 * 1_000_000 -> 불가능
    // DP로 풀어보자! -> 실패.. 시간초과...
    // Stack? -> 성공
    public static int[] solution(int[] numbers) {
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

    public static void main(String[] args) {
        int[] arr = {9, 1, 5, 3, 6, 2};
        solution(arr);
    }
}
