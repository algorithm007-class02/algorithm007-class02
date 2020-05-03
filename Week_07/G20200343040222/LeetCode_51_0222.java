
public class LeetCode_51_0222 {


    /**
     * 回溯
     * 时间复杂度为  O((n^3)n!) 空间复杂度为 O(n)
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        }
        List<List<String>> res = new ArrayList<>();
        backstack(res, 0, board);
        return res;
    }

    private void backstack(List<List<String>> res, int colIndex, char[][] board) {
        if (colIndex == board.length) {
            res.add(contectChar(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (validate(board, i , colIndex)) {
                board[i][colIndex] = 'Q';
                backstack(res, colIndex + 1, board);
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'Q' && (Math.abs(row - i) == Math.abs(col - j)|| row == i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> contectChar(char[][] board) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }


    /**
     * 回溯2
     * 时间复杂度为  O((n)n!)  空间复杂度为 O(n)
     * @param n
     * @return
     */
    public List<List<String>> solveNQueensRe(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        boolean[] col = new boolean[n];
        boolean[] dia1 = new boolean[2 * n - 1];
        boolean[] dia2 = new boolean[2 * n - 1];
        solver(board, 0, n, col, dia1, dia2, res);
        return res;
    }

    private void solver(char[][] board, int index, int n, boolean[] col, boolean[] dia1, boolean[] dia2, List<List<String>> res) {
        if (index == n) {
            res.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] || dia1[index + n - i - 1] || dia2[index + i]) {
                continue;
            }
            col[i] = true;
            dia1[index + n - i - 1] = true;
            dia2[index + i] = true;
            board[index][i] = 'Q';
            solver(board, index + 1, n, col, dia1, dia2, res);
            col[i] = false;
            dia1[index + n - i - 1] = false;
            dia2[index + i] = false;
            board[index][i] = '.';
        }

    }
}