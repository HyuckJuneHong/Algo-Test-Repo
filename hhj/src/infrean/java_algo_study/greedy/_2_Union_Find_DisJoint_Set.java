package src.infrean.java_algo_study.greedy;

public class _2_Union_Find_DisJoint_Set {

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

        if (fa != fb)
            parent[fa] = fb;
    }

    public static void main(String[] args) {

        int n = 10;

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i < n; i++) {
            Edge edge = new Edge(1, 2, 10);

            int a = edge.a;
            int b = edge.b;

            union(a, b);
        }
    }

    public static class Edge {
        int a;
        int b;
        int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}
