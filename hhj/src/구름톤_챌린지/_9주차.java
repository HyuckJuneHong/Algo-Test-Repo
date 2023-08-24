package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * [문제 설명]
 * - N * N 크기의 정사각형 모양의 땅 있음
 * - (y, x) : 1 * 1 크기의 작은 땅으로 나눴을 때 위에서 y 번째 왼쪽에서 x 번째에 위치한 땅의 좌표
 * - 모든 땅에는 폭탄 값이 있다. (초기값은 0)
 * - K개의 폭탄을 이 땅에 떨어트릴 것
 * - 1 * 1 크기의 땅 위에 폭탄이 떨어지면 떨어진 땅과 상하좌우 칸에 영향을 끼침
 * - 땅의 상태가 #이면 폭탄값은 변하지 않음
 * - 0이라면 1 증가
 * - @이라면 2증가
 * <p>
 * [입력]
 * - N : 한변의 길이 (1~200)
 * - K : 폭탄 횟수 (1~500_000)
 */
public class _9주차 {
    static final int[] DX = {-1, 0, 1, 0};
    static final int[] DY = {0, 1, 0, -1};
    static int[][] dis;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[][] bomb = new int[K][2];
        String[][] land = new String[N][N];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                land[i][j] = input[j];
            }
        }

        for (int i = 0; i < K; i++) {
            input = br.readLine().split(" ");
            bomb[i][0] = Integer.parseInt(input[0]);
            bomb[i][1] = Integer.parseInt(input[1]);
        }

        int answer = getMaxBomb(land, bomb, N, K);
        System.out.print(answer);
    }

    private static int getMaxBomb(String[][] land, int[][] bomb, int N, int K) {
        dis = new int[N][N];

        for (int i = 0; i < K; i++) {
            int y = bomb[i][0] - 1;
            int x = bomb[i][1] - 1;
            checkLand(land, x, y);

            for (int j = 0; j < 4; j++) {
                int ny = y + DY[j];
                int nx = x + DX[j];

                if (ny >= 0 && nx >= 0 && ny < N && nx < N && !land[ny][nx].equals("#")) {
                    checkLand(land, nx, ny);
                }
            }
        }

        return max;
    }

    private static void checkLand(String[][] land, int x, int y) {
        if (land[y][x].equals("0")) {
            dis[y][x] += 1;
        } else if (land[y][x].equals("@")) {
            dis[y][x] += 2;
        }

        if (dis[y][x] > max) {
            max = dis[y][x];
        }
    }
}
