package src.알고리고.level2;

public class 쿼드압축_후_개수_세기 {
    static int zero;
    static int one;

    public int[] solution(int[][] arr) {
        dfs(arr, 0, 0, arr.length);

        return new int[]{zero, one};
    }

    private void dfs(int[][] arr, int x, int y, int current) {
        if (check(arr, x, y, current)) {
            if (arr[y][x] == 0) {
                zero++;
            } else {
                one++;
            }

            return;
        }

        int next = current / 2;
        dfs(arr, x, y, next);
        dfs(arr, x + next, y, next);
        dfs(arr, x, y + next, next);
        dfs(arr, x + next, y + next, next);
    }

    private boolean check(int[][] arr, int x, int y, int current) {
        int number = arr[y][x];

        for (int i = y; i < y + current; i++) {
            for (int j = x; j < x + current; j++) {
                if (arr[i][j] != number) {
                    return false;
                }
            }
        }

        return true;
    }
}
