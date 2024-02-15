package src.백준.DFS_BFS_필수_문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class G5_1068_트리 {

	static List<List<Integer>> graph = new ArrayList<>();
	static int root = 0;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String[] nodes = br.readLine().split(" ");
		int delete = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < nodes.length; i++) {
			int num = Integer.parseInt(nodes[i]);

			if (num == -1) {
				root = i;
				continue;
			}

			graph.get(num).add(i);
		}

		if (root == delete) {
			System.out.println(0);
			return;
		}

		dfs(delete, root);

		System.out.println(answer);

		bw.flush();
		br.close();
		bw.close();
	}

	private static void dfs(int delete, int depth) {
		boolean check = false;

		if (graph.get(depth).isEmpty()) {
			answer += 1;
			return;
		}

		for (int num : graph.get(depth)) {
			if (delete != num) {
				dfs(delete, num);
				check = true;
			}
		}

		if (!check) {
			answer += 1;
		}
	}
}
