package src.인프런.그리디;

public class _1_Union_Find_Form {

	//집합
	static int[] parent;

	//해당 집합을 찾는 메소드
	public static int find(int v) {
		if (v == parent[v])
			return v;
		else
			return parent[v] = find(v);
	}

	//집합 A, B를 하나로 만드는 함수
	public static void union(int a,
		int b) {
		int fa = find(a);
		int fb = find(b);

		if (fa != fb)
			parent[fa] = fb;
	}
}
