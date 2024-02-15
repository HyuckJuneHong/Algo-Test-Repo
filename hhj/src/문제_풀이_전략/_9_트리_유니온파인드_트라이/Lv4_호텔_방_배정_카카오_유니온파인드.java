package src.문제_풀이_전략._9_트리_유니온파인드_트라이;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 k : 호텔에 있는 방의 갯수 (1~1_000_000_000_000)
 room_number[] : 고객들이 원하는 방 번호가 순서대로 들어있는 배열 (len=1~200_000, val=1~k)
 return long[] : 각 고객에게 배정되는 방 번호를 순서대로 담아 반환

 1. 이미 등장한 방 번호 등장 시, 이미 등장한 방 번호를 건너뛰고 등장하지 않은 방 번호를 찾는다.
 - 연속적인 방 번호를 집합으로 관리하자.
 - 해당 방 번호가 집합 내에 있다면, 해당 방 번호 = 집합 내 최댓값 + 1이다.
 2. 등장하는 방 번호를 서로소 집합의 원소로 하여 유니온 파인드를 진행하자.
 - 서로소 집합과 유니온 파인드를 위해 Node 클래스 구축
 - Node 클래스는 깊이와 부모 상태 외에 최댓값 상태도 갖게 한다.
 3. 유니온 파인드는 다음과 같이 진행하자.
 - k값이 너무 크기 때문에 처음부터 Node들을 생성하고 시작할 수 없으니 Map을 활용
 - Node 객체가 없다면 해당 방 번호는 등장한 것이 아니기 때문에, 입력받은 방 번호 그대로 배정 가능
 - Node 객체가 있다면 이미 배정된 방 번호이므로 해당 방 번호가 포함된 서로소 집합에서 가장 큰 값 + 1을 번호로 배정
 - 마지막으로 연속된 방들과 합쳐야 하니 room 기준 +1, -1을 하여 배정된 방이 있는지 확인
 */
public class Lv4_호텔_방_배정_카카오_유니온파인드 {

	public long[] solution(long k, long[] room_number) {
		List<Long> answer = new ArrayList<>();
		Map<Long, Node> nodes = new HashMap<>();

		for (long room : room_number) {
			if (nodes.containsKey(room)) {
				Node node = nodes.get(room);
				room = node.getMax() + 1;
			}

			Node node = new Node(room);
			nodes.put(room, node);

			if (nodes.containsKey(room + 1)) {
				node.merge(nodes.get(room + 1));
			}

			if (nodes.containsKey(room - 1)) {
				node.merge(nodes.get(room - 1));
			}

			answer.add(room);
		}

		return answer.stream()
			.mapToLong(Long::longValue)
			.toArray();
	}

	private static class Node {

		public long max;
		public int depth;
		public Node parent;

		public Node(long roomNumber) {
			depth = 1;
			parent = null;
			max = roomNumber;
		}

		public long getMax() {
			return this.getRoot().max;
		}

		public boolean isConnected(Node o) {
			return this.getRoot() == o.getRoot();
		}

		public void merge(Node o) {
			if (this.isConnected(o)) {
				return;
			}

			Node root1 = this.getRoot();
			Node root2 = o.getRoot();

			if (root1.depth > root2.depth) {
				root2.parent = root1;
			} else if (root1.depth < root2.depth) {
				root1.parent = root2;
			} else {
				root2.parent = root1;
				root1.depth += 1;
			}

			root1.max = root2.max = Math.max(root1.max, root2.max);
		}

		private Node getRoot() {
			if (this.parent == null) {
				return this;
			}

			return this.parent.getRoot();
		}
	}
}
