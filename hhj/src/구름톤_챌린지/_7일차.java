package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _7일차 {
    static final int[] DX = {-1, 0, 1, 1, 1, 0, -1, -1};
    static final int[] DY = {1, 1, 1, 0, -1, -1, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int K = Integer.parseInt(input1[1]);
        int[][] M = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                M[i][j] = Integer.parseInt(input2[j]);
            }
        }

        int answer = getFlag(N, K, M);
        System.out.print(answer);
    }

    private static int getFlag(int N, int K, int[][] M) {
        int result = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (M[y][x] != 0) {
                    continue;
                }

                int count = 0;

                for (int k = 0; k < 8; k++) {
                    int nx = x + DX[k];
                    int ny = y + DY[k];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && M[ny][nx] == 1) {
                        count++;
                    }
                }

                if (count == K) {
                    result++;
                }
            }
        }

        return result;
    }
}
