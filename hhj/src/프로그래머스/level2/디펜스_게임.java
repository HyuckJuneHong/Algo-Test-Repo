package src.프로그래머스.level2;

import java.util.PriorityQueue;

public class 디펜스_게임 {
    public int solution(
            int n,      // 병사수 (1 ~ 1_000_000_000)
            int k,      // 무적권 사용 가능한 횟수 (1 ~ 500_000)
            int[] enemy // enemy[i] 라운드마다 적수 (남은 병사는 적수만큼 사라짐) (1 ~ 1_000_000)
    ) {
        int answer = 0;

        if (k >= enemy.length) {
            return enemy.length;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < enemy.length; i++) {
            int current = enemy[i];

            if (n < current && k == 0) {
                break;
            }

            pq.add(current);

            if (n < current) {
                n += pq.poll();
                k--;
            }

            n -= current;
            answer++;
        }

        return answer;  // 몇 라운드까지 막을 수 있는 지 반환
    }
}
