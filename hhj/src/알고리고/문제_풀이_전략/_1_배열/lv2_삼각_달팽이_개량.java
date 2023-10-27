package src.알고리고.문제_풀이_전략._1_배열;

/**
 * 문제풀이
 * 1. 크기가 n인 배열 생성
 * 2. 방향을 나타낼 배열 생성
 * 3. 방향을 나타내는 배열에 따라 아래, 오른쪽, 대각선 왼쪽 위로 순차적 증가
 * 4. 이따 방향 전환은 더 이상 진행할 수 없을 때 진행
 * 5. 방향 전환 후에도 더 이상 진행할 수 없다면 종료
 */
public class lv2_삼각_달팽이_개량 {

    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int value = 1;
        int y = 0;
        int x = 0;
        int d = 0;

        while (true) {
            arr[y][x] = value++;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx == n || ny == n || nx == -1 || ny == -1 || arr[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];

                if (nx == n || ny == n || nx == -1 || ny == -1 || arr[ny][nx] != 0) {
                    break;
                }
            }

            x = nx;
            y = ny;
        }

        int[] answer = new int[value - 1];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = arr[i][j];
            }
        }

        return answer;
    }
}
