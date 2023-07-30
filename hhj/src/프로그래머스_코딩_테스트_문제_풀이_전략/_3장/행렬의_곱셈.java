package src.프로그래머스_코딩_테스트_문제_풀이_전략._3장;

public class 행렬의_곱셈 {
    /**
     * @param arr1 : 2차원 행렬1
     * @param arr2 : 2차원 행렬2
     * @return : 행렬1 * 행렬2 결과
     */
    public int[][] solution(int[][] arr1,
                            int[][] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int k = arr2[0].length;
        int[][] answer = new int[m][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < n; l++) {
                    answer[i][j] += arr1[i][l] * arr2[l][j];
                }
            }
        }

        return answer;
    }
}
