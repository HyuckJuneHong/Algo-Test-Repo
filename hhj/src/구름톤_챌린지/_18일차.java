package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 문제
 - 한 변 길이 N인 정사각형
 - 정사각형에 M개 반직선 그린 뒤 교차하는 점 갯수

 반직선 과정
 1. (y, x)를 정함
 - (y, x)는 주어진 정사각형을 1*1 크기 정사각형으로 나눴을 때 y번째 행의 x번째 열
 2. 반직선 그릴 방향 d를 정함
 - 상하좌우
 3. 반직선을 그림
 - 항상 시작 칸의 테두리에서 시작
 - 같은 칸을 지나는 평행한 직선이 서로 만나지 않도록 그림

 입력
 - N : 정사각형 크기 (1~100)
 - M : 반직선 갯수 (1~100_000)
 - d : 방향 (U, D, L, R)

 */
public class _18일차 {

	static long[][] h;
	static long[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		long M = Long.parseLong(input[1]);
		h = new long[N][N];
		v = new long[N][N];

		for (long i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int y = Integer.parseInt(input[0]) - 1;
			int x = Integer.parseInt(input[1]) - 1;
			char d = input[2].charAt(0);
			drawLine(N, y, x, d);
		}

		long answer = count(N);
		System.out.print(answer);
	}

	private static long count(int N) {
		long count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count += h[i][j] * v[i][j];
			}
		}

		return count;
	}

	private static void drawLine(int N, int y, int x, char d) {
		if (d == 'R') {
			for (int j = x; j < N; j++) {
				h[y][j]++;
			}
		} else if (d == 'L') {
			for (int j = x; j >= 0; j--) {
				h[y][j]++;
			}
		} else if (d == 'D') {
			for (int j = y; j < N; j++) {
				v[j][x]++;
			}
		} else {
			for (int j = y; j >= 0; j--) {
				v[j][x]++;
			}
		}
	}
}
