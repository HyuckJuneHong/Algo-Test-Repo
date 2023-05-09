package src.programmers.level2._8주차;

public class DP_땅따먹기 {

    /**
     * 게임의 땅은 N행 4열로 이루어짐
     * 모든 칸에는 점수가 쓰여져 있다.
     * 1행부터 땅을 밟으며 한행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 한다.
     * 단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없다.
     *
     * @param land : 땅 정보
     * @return : 마지막 행까지 내려왔을 때 점수의 최대값
     */

    static int solution(int[][] land) {

        int n = land.length;

        //DP Table Create
        int[][] dp = new int[n][4];

        //DP Table 초기화
        for(int i=0; i<4; i++){
            dp[0][i] = land[0][i];
        }

        //DP Table add
        for(int i=1; i<n; i++){

            for(int j=0; j<4; j++){

                int max = 0;
                for(int k=0; k<4; k++){
                    if(j!=k){
                        max = Math.max(max, dp[i-1][k]);
                    }
                }
                dp[i][j] = max + land[i][j];
            }
        }

        int max = 0;

        for(int i=0; i<4; i++){
            max = Math.max(max, dp[n-1][i]);
        }

        return max;
    }
}
