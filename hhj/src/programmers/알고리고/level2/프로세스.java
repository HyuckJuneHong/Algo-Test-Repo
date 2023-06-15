package src.programmers.알고리고.level2;

import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class 프로세스 {

    /**
     * 1. 인쇄 대기 목록의 가장 앞 문서(J)를 꺼낸다.
     * 2. 나머지 인쇄 대기목록 중 J보다 중요한 문서가 있으면 J를 마지막에 넣는다.
     * 3. 그렇지 않으면 J 인쇄
     *
     * @param priorities : 문서의 중요도가 담긴 배열
     * @param location   : 요청 문서 현재 대기 목록
     * @return : 요청 문서가 언제 인쇄되는 지 반환
     */
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int size = priorities.length;
        Deque<Integer> priorityQ = new ArrayDeque<>();

        for (int priority : priorities) {
            priorityQ.offer(priority);
        }

        Arrays.sort(priorities);

        while (!priorityQ.isEmpty()) {
            int currentPriority = priorityQ.poll();
            int currentSize = size - 1 - answer;

            if (currentPriority < priorities[currentSize]) {
                priorityQ.offer(currentPriority);
                location = location == 0 ? currentSize : --location;
            } else if (location == 0) {
                answer++;
                break;
            } else {
                answer++;
                location--;
            }
        }

        return answer;
    }
}
