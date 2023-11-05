package src.알고리고.문제_풀이_전략._1_배열;

/*
문제풀이
1. places에서 P를 확인
2. P가 나오면, 해당 위치에서 상하좌우 체크
    - P이면 return 0
    - O이면 해당 위치로 이동 후 이전위치를 제외한 상하좌우 체크
        - P이면 return 0
        - 그 외는 continue
    - X이면 continue
3. 모두 통과 시, return 1
*/
public class Lv2_거리두기 {

	private final int[] dx = {-1, 0, 1, 0};
	private final int[] dy = {0, 1, 0, -1};

	public int[] solution(String[][] places) {
		int[] answer = new int[5];

		for (int i = 0; i < 5; i++) {
			char[][] place = new char[5][5];

			for (int j = 0; j < 5; j++) {
				place[j] = places[i][j].toCharArray();
			}

			if (!validateNext(place)) {
				answer[i] = 0;
			} else {
				answer[i] = 1;
			}
		}

		return answer;
	}

	private boolean validateNext(char[][] place) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (place[i][j] != 'P') {
					continue;
				}

				if (!validateNext(place, i, j)) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean validateNext(char[][] place, int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny == 5 || nx == 5 || ny == -1 || nx == -1) {
				continue;
			}

			if (place[ny][nx] == 'P' || place[ny][nx] == 'O' && !validateNext(place, ny, nx, y, x)) {
				return false;
			}
		}

		return true;
	}

	private boolean validateNext(char[][] place, int y, int x, int py, int px) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny == py && nx == px) {
				continue;
			}

			if (ny < 5 && nx < 5 && ny >= 0 && nx >= 0 && place[ny][nx] == 'P') {
				return false;
			}
		}

		return true;
	}
}
