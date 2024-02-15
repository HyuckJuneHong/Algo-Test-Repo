package src.programmers.level2;

/**
 * - 최소 필요 피로도 : 던전 탐험을 위해 있어야할 최소 피로도
 * - 소모 피로도 : 던전 탐험 후 소모되는 피로도
 * <p>
 * - 입력 형식
 * - k : 현재 피로도
 * - dungeons : 던전별 {최소필요피로도, 소모피로도}를 담은 2차원 배열
 * - 출력 형식
 * - 유저가 탐험할 수 있는 최대 던전 수
 * - 제한사항
 * - k : 1~5000
 * - 최소필요피로도 >= 소모피로도
 * - dungeons 세로(행) : 1~8
 */
public class 피로도 {

    static int answer = 0;
    static boolean[] visited;

    public static int solution(int k,
                               int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);

        return answer;
    }

    private static void dfs(int k,
                            int[][] dungeons,
                            int depth) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || dungeons[i][0] > k) {
                continue;
            }

            visited[i] = true;
            dfs(k - dungeons[i][1], dungeons, depth + 1);
            visited[i] = false;
        }

        answer = Math.max(answer, depth);
    }
}
