package src.알고리고.문제_풀이_전략._9_트리_유니온파인드_트라이;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 nodeinfo : 이진트리를 구성하는 노드들의 좌표가 담긴 2차원 배열 (len=1~10_000)
 - nodeinfo[i] : i+1 노드
 - nodeinfo[i][0 or 1] : i+1 노드의 x, y 좌표
 - 좌표값 : 0~100_000
 return : 노드들로 구성된 이진트리를 전위 순회, 후위 순회한 결과를 2차원 배열에 순서대로 담아서 반환

 1. Node를 표현할 Node 클래스 생성
 2. nodeinfo를 토대로 트리를 만든다.
 - 트리 생성 전 nodeinfo를 y 기준으로 내림차순 정렬 -> 루트 노드를 찾기 위함
 - 트리 생성 메서드 및 노드 삽입 메서드 생성 -> 이때 재귀 활용
 - 같은 레벨 : y가 동일
 - 자식 노드의 y < 부모 노드의 y
 - 임의 노드의 X > 임의 노드의 왼쪽 서브트리 모든 노드 X 값
 - 임의 노드의 X < 임의 노드의 오른쪽 서브트리 모든 노드 X 값
 3. 전위 순회, 후위 순회 재귀로 판단 후 반환
 - 전위 순회할 pre 메서드 생성 -> 재귀 활용
 - 후위 순회할 post 메서드 생성 -> 재귀 활용
 */
public class Lv3_길_찾기_게임_카카오 {

	static Node root;

	public int[][] solution(int[][] nodeinfo) {
		List<Node> nodes = new ArrayList<>();
		List<Integer> preList = new ArrayList<>();
		List<Integer> postList = new ArrayList<>();
		int n = nodeinfo.length;

		init(nodeinfo, nodes, n);
		generateTree(nodes, n);
		pre(root, preList);
		post(root, postList);

		return new int[][] {
			preList.stream().mapToInt(Integer::intValue).toArray(),
			postList.stream().mapToInt(Integer::intValue).toArray()
		};
	}

	private void pre(Node node, List<Integer> list) {
		if (node == null) {
			return;
		}

		list.add(node.n);
		pre(node.left, list);
		pre(node.right, list);
	}

	private void post(Node node, List<Integer> list) {
		if (node == null) {
			return;
		}

		post(node.left, list);
		post(node.right, list);
		list.add(node.n);
	}

	private void insert(Node root, Node node) {
		// 왼쪽 서브 트리
		if (root.x > node.x) {
			if (root.left == null) {
				root.left = node;
				return;
			}

			insert(root.left, node);
			return;
		}

		// 오른쪽 서브 트리
		if (root.right == null) {
			root.right = node;
			return;
		}

		insert(root.right, node);
	}

	private void generateTree(List<Node> nodes, int n) {
		root = nodes.get(0);

		for (int i = 1; i < n; i++) {
			insert(root, nodes.get(i));
		}
	}

	private void init(int[][] nodeinfo, List<Node> nodes, int n) {
		for (int i = 1; i <= n; i++) {
			int x = nodeinfo[i - 1][0];
			int y = nodeinfo[i - 1][1];
			nodes.add(new Node(x, y, i));
		}

		Collections.sort(nodes);
	}

	private static class Node implements Comparable<Node> {

		int x;
		int y;
		int n;
		Node left;
		Node right;

		public Node(int x, int y, int n) {
			this.x = x;
			this.y = y;
			this.n = n;
		}

		@Override
		public int compareTo(Node o) {
			return o.y - this.y;
		}
	}
}
