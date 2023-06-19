package src.programmers.알고리고.level2;

public class 행렬의_곱셈 {

    /**
     * @param arr1 : 2차원 행렬1
     * @param arr2 : 2차원 행렬2
     * @return : 행렬1 * 행렬2 결과
     */
    public int[][] solution(int[][] arr1,
                            int[][] arr2) {

        int size1 = arr1.length;
        int size2 = arr2[0].length;
        int size3 = arr1[0].length;

        int[][] answer = new int[size1][size2];

        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                for (int k = 0; k < size3; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
