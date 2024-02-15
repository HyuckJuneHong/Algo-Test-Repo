package src.programmers.level2;

public class 땅따먹기 {
    /**
     * - 시간 복잡도 : N * 4
     */
    static int solution(int[][] land) {
        int answer = 0;
        int size = land.length;
        int[][] table = new int[size][4];

        for (int i = 0; i < 4; i++) {
            table[0][i] = land[0][i];
        }

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;

                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        max = Math.max(max, table[i - 1][k]);
                    }
                }

                table[i][j] = max + land[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, table[size - 1][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };
        solution(arr);
    }
}
