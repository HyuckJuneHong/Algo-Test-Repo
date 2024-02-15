package src.문제_풀이_전략._9_그래프;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 arrows : 이동하는 방향이 담긴 1차원 배열(len=1~100_000, val=0~7)
 return : 방의 갯수 (방=사방이 막혔을 때)

 1. 방향을 나타낼 1차원 배열 생성 (방향 = 숫자가 적힌)
 2. 그래프 생성
 - 100_000 크기이기 때문에, 인접행렬보단 인접리스트를 이용.
 - 그래프는 어떤 좌표인 지 알기 위해, 해시맵으로 표현하자.
 - 각 좌표 상태를 나타낼 정점 클래스를 생성하자.
 - 해당 클래스가 좌표 뿐 아니라, 간선 상태를 갖게 하자. (간선 = 연결된 정점, Set으로 선언)
 - 해시맵 키로 가져갈 좌표키 상태를 갖게 하자.(좌표키 = "(x, y)", 문자열로 선언)
 3. arrows를 순회하며 그래프를 그려간다.
 - 좌표 이동마다 방이 생성되는 지 체크한다.
 - 기존 간선이 있을 때 체크할 필요는 없기 때문에, Set으로 선언 (속도면에서도 더 빠름, Set은 상수)
 - 방 생성 조건은 다음과 같다.
 - 기존에 방문했던 정점을 새로운 간선(상, 하, 좌, 우)을 통해 방문할 때 1개 생성
 - 기존에 방문했던 정점을 새로운 간선(대각선)을 통해 방문할 때 2개 생성
 - 중간에 만나는 정점도 배열로 표현하자.
 - 즉, arrows 변수가 1칸 이동이 아닌, 0.5칸 이동으로 바꾼 후 2번씩 반복해서 체크하면 모두 1개 생성이 됨
 */
public class Lv5_방의_개수 {

	private static final int[] DX = {0, 1, 1, 1, 0, -1, -1, -1};
	private static final int[] DY = {-1, -1, 0, 1, 1, 1, 0, -1};

	public int solution(int[] arrows) {
		int answer = 0;

		Map<String, Vertex> graph = new HashMap<>();
		Vertex cv = new Vertex(0, 0);

		graph.put(cv.id, cv);

		for (int arrow : arrows) {
			for (int i = 0; i < 2; i++) {
				int nx = cv.x + DX[arrow];
				int ny = cv.y + DY[arrow];
				Vertex nv = new Vertex(nx, ny);

				if (graph.containsKey(nv.id) && !cv.isConnect(nv)) {
					answer++;
				}

				graph.putIfAbsent(nv.id, nv);
				nv = graph.get(nv.id);
				cv.connect(nv);
				nv.connect(cv);
				cv = graph.get(nv.id);
			}
		}

		return answer;
	}

	private static class Vertex {

		public String id;
		public int x;
		public int y;
		public Set<Vertex> connected;

		public Vertex(int x, int y) {
			this.x = x;
			this.y = y;
			this.id = String.format("(%d, %d)", x, y);
			this.connected = new HashSet<>();
		}

		public void connect(Vertex vertex) {
			this.connected.add(vertex);
		}

		public boolean isConnect(Vertex vertex) {
			return this.connected.contains(vertex);
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Vertex) {
				Vertex v = (Vertex)o;
				return this.id.equals(v.id);
			}

			return false;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}
	}
}
