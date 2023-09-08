package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 문제 설명
 - 게임 한 변 길이 : N
 - 보드는 한 변의 길이가 1인 N^2개의 칸으로 나눠짐
 - 각 칸에는 <command>에 해당하는 방향으로 <count> 칸만큼 이동
 - 플레이하는 사람은 처음에 보드 칸 중 하나에 말 올려놓음
 - 각 칸에 지시대로 말 이동
 - 만약 보드 밖이면 반대쪽 첫번째로 이동
 - 이동하다 방문한 칸을 다시 지나야 하는 경우 게임 종료
 - 게임 점수 : 게임 종료되기 전까지 방문한 서로 다른 칸 개수

 입력
 - 격자 보드 크기 : N (4~200)
 - 구름이가 말을 올려둔 칸 좌표 : R1, C1 (1~N)
 - 플레이거가 말을 올려둔 칸 좌표 : R2, C2 (1~N)

 문제 풀이
 1. 게임 시작
 2. 점수 확인
 */
public class _10일차 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] pointG = br.readLine().split(" ");
		String[] pointP = br.readLine().split(" ");
		int[] goorm = new int[] {Integer.parseInt(pointG[0]), Integer.parseInt(pointG[1])};
		int[] player = new int[] {Integer.parseInt(pointP[0]), Integer.parseInt(pointP[1])};
		String[][] board = new String[N][N];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");

			for (int j = 0; j < N; j++) {
				board[i][j] = input[j];
			}
		}

		String[] answer = play(board, goorm, player, N);
		System.out.println(answer[0] + " " + answer[1]);
	}

	private static String[] play(String[][] board, int[] goorm, int[] player, int N) {
		int goormScore = getScore(board, goorm, N);
		int playerScore = getScore(board, player, N);
		String[] winner = new String[2];

		if (goormScore > playerScore) {
			winner[0] = "goorm";
			winner[1] = String.valueOf(goormScore);
		} else {
			winner[0] = "player";
			winner[1] = String.valueOf(playerScore);
		}

		return winner;
	}

	private static int getScore(String[][] board, int[] player, int N) {
		int[][] dis = new int[N][N];
		int x = player[1] - 1;
		int y = player[0] - 1;
		dis[y][x] = 1;

		game:
		while (true) {
			String b = board[y][x];
			int count = Integer.parseInt(b.substring(0, b.length() - 1));
			int[] next = move(b.substring(b.length() - 1));

			for (int i = 0; i < count; i++) {
				int nx = x + next[1];
				int ny = y + next[0];
				nx = (nx == -1) ? (N - 1) : (nx % N);
				ny = (ny == -1) ? (N - 1) : (ny % N);

				if (dis[ny][nx] != 0) {
					break game;
				}

				dis[ny][nx] = dis[y][x] + 1;
				x = nx;
				y = ny;
			}
		}

		return dis[y][x];
	}

	private static int[] move(String command) {
		if (command.equals("U")) {
			return new int[] {-1, 0};
		}

		if (command.equals("D")) {
			return new int[] {1, 0};
		}

		if (command.equals("R")) {
			return new int[] {0, 1};
		}

		return new int[] {0, -1};
	}
}
