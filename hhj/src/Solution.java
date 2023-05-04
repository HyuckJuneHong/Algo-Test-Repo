package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int vertexSize = 7;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static boolean[] visit = new boolean[vertexSize];

    static int[] answer = new int[vertexSize];

    public static void main(String[] args) {
        init();

        bfs(1);

        for(int i=2; i<vertexSize; i++){
            System.out.println(answer[i]);
        }
    }

    private static void bfs(int vStart) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vStart);
        visit[vStart] = true;
        answer[vStart] = 0;

        while (!queue.isEmpty()){
            int currentV = queue.poll();

            for(int nextV : graph.get(currentV)){
                if(!visit[nextV]){
                    visit[nextV] = true;
                    queue.offer(nextV);
                    answer[nextV] = answer[currentV] + 1;
                }
            }
        }
    }

    public static void init() {

        int[][] arr = new int[][]{
                {1, 3},
                {1, 4},
                {2, 1},
                {2, 5},
                {3, 4},
                {4, 5},
                {4, 6},
                {6, 2},
                {6, 5}
        };

        for (int i = 0; i < vertexSize; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : arr) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
        }
    }
}
