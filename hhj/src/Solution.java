package src;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int answer = 0;
    static boolean[] visit = new boolean[10001];
    static int[] move = new int[]{-1, 1, 5};

    public static void main(String[] args) {

        System.out.println(bfs(5, 14));
    }

    private static int bfs(int start,
                           int end) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visit[start] = true;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                int point = queue.poll();

                for(int m : move){
                    int nx = point + m;

                    if(nx == end) return answer+1;

                    if(nx >= 1 && nx <= 10000 && !visit[nx]){
                        visit[nx] = true;
                        queue.offer(nx);
                    }
                }
            }
            answer++;
        }
        return 0;
    }
}
