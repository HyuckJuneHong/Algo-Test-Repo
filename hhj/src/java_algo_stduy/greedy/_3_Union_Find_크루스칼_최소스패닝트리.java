package src.java_algo_stduy.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _3_Union_Find_크루스칼_최소스패닝트리 {

    static int[] parent;

    public static int find(int v) {
        if (v == parent[v])
            return v;
        else
            return parent[v] = find(v);
    }

    public static void union(int a,
                             int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa != fb) {
            parent[fa] = fb;
        }
    }

    public static class Edge implements Comparable<Edge> {

        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {

            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {

        int n = 9;
        int m = 12;

        parent = new int[n + 1];

        List<Edge> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = 0;
            int b = 0;
            int cost = 0;

            list.add(new Edge(a, b, cost));
        }

        Collections.sort(list);

        int answer = 0;

        for (Edge e : list) {
            int fa = find(e.v1);
            int fb = find(e.v2);

            if (fa != fb) {
                answer += e.cost;
                union(fa, fb);
            }
        }

        System.out.println(answer);
    }
}