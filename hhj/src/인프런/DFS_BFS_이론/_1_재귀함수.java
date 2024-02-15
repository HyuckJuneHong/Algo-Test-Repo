package src.인프런.DFS_BFS_이론;

public class _1_재귀함수 {

	public static void main(String[] args) {
		dfs(3);
	}

	public static void dfs(int n) {

		if (n == 0)
			return;

		System.out.println(n);

		dfs(n - 1);
	}
}
