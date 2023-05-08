package src._8주차;

public class 땅따먹기 {

    /**
     * 게임의 땅은 N행 4열로 이루어짐
     * 모든 칸에는 점수가 쓰여져 있다.
     * 1행부터 땅을 밟으며 한행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 한다.
     * 단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없다.
     *
     * @param land : 땅 정보
     * @return : 마지막 행까지 내려왔을 때 점수의 최대값
     */

    static int answer = 0;

    static int n;

    static boolean[] visit = new boolean[4];

    static int solution(int[][] land) {

        n = land.length;

        dfs(0, 0, land);

        return answer;
    }

    static void dfs(int depth,
                    int sum,
                    int[][] land) {

        if (depth == n) {
            answer = Math.max(sum, answer);
            return;
        }

        for(int i=0; i<4; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(depth+1, sum + land[depth][i], land);
                visit[i] = false;
            }
        }
    }
}
