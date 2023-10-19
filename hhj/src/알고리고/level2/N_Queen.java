package src.알고리고.level2;

/*
    not : [0][j], [i][0] : 각 열마다 반드시 행이 존재, 즉 행 하나로 표현하고 행의 값을 열이라 생각하면 될 듯.
    not : [0 + k][1 + k] : (0 + k) - (1 + k) == (1 + k) - (0 + k) : |i - j| == |board[i] - board[j]|
*/
public class N_Queen {

    static int[] board;
    static int answer = 0;

    public int solution(int n) {
        init(n);
        dfs(n, 0);

        return answer;
    }

    public void dfs(int n, int col) {
        if (col == n) {
            answer++;

            return;
        }

        for (int row = 0; row < n; row++) {
            board[col] = row;

            if (valid(col)) {
                dfs(n, col + 1);
            }
        }
    }

    public boolean valid(int col) {
        for (int i = 0; i < col; i++) {
            if (board[i] == board[col]) {
                return false;
            }

            if (Math.abs(i - col) == Math.abs(board[i] - board[col])) {
                return false;
            }
        }

        return true;
    }

    public void init(int n) {
        board = new int[n];
    }
}
