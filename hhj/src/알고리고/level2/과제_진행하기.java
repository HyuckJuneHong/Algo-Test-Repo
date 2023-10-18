package src.알고리고.level2;

import java.util.*;

public class 과제_진행하기 {

    static PriorityQueue<Subject> pq;

    public String[] solution(String[][] plans) {
        List<Subject> answer = new ArrayList<>();
        init(plans);

        Deque<Subject> stop = new ArrayDeque<>();
        Subject cur = pq.poll();
        int now = cur.start;

        while (true) {
            Subject next = pq.peek();

            // 현재 진행 중인 과제(cur)의 종료 시간이 다음 과제(next)의 시작 시간보다 이전인지 확인
            if (!pq.isEmpty() && now + cur.playTime > next.start) {
                // 멈춘 작업은 stop 덱에 추가
                stop.push(new Subject(cur.name, cur.start, cur.playTime - (next.start - now)));
                // 새로운 작업이 시작
                cur = pq.poll();
                now = cur.start;
            } else {
                answer.add(cur);
                now += cur.playTime;

                // 다음 작업이 존재하고 바로 시작할 수 있다면
                if (!pq.isEmpty() && now == pq.peek().start) {
                    cur = pq.poll();
                    // 만약 멈춘 작업이 있다면
                } else if (!stop.isEmpty()) {
                    cur = stop.pop();
                    // 아직 시작하지 않은 새로운 작업이 있다면
                } else if (!pq.isEmpty()) {
                    cur = pq.poll();
                    now = cur.start;
                    //  모든 과제가 완료
                } else {
                    break;
                }
            }
        }

        return answer.stream()
                .map(a -> a.name)
                .toArray(String[]::new);
    }

    public void init(String[][] plans) {
        pq = new PriorityQueue<>();

        for (String[] plan : plans) {
            pq.add(new Subject(plan[0], plan[1].split(":"), plan[2]));
        }
    }

    public class Subject implements Comparable<Subject> {

        String name;
        int start;
        int playTime;

        public Subject(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }

        public Subject(String name, String[] time, String playTime) {
            this.name = name;
            this.start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            this.playTime = Integer.parseInt(playTime);
        }

        @Override
        public int compareTo(Subject o) {
            return this.start - o.start;
        }

        @Override
        public String toString() {
            return "\n[" + name + ", " + start + ", " + playTime + "]";
        }
    }
}
