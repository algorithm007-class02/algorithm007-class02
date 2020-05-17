public class LeetCode_37_0222 {
    /**
     * 数独首先行，列，还有 3*3 的方格内数字是 1~9 不能重复。
     * 声明布尔数组，表明行列中某个数字是否被使用了， 被用过视为 true，没用过为 false。
     * 初始化布尔数组，表明哪些数字已经被使用过了。
     * 尝试去填充数组，只要行，列， 还有 3*3 的方格内 出现已经被使用过的数字，我们就不填充，否则尝试填充。
     * 如果填充失败，那么我们需要回溯。将原来尝试填充的地方改回来。
     * 递归直到数独被填充完成。
     *
     * 回溯
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] boxUsed = new boolean[3][3][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num = board[i][j] - '0';
                if (0 <= num && num <= 9) {
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[i / 3][j / 3][num] = true;
                }
            }
        }
        recusiveSolveSudoku(board, rowUsed, colUsed, boxUsed, 0, 0);
    }

    private boolean recusiveSolveSudoku(char[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] boxUsed, int row, int col) {
        if (col == board[0].length) {
            col = 0;
            row++;
            if (row == board.length) {
                return true;
            }
        }
        if (board[row][col] == '.') {
            for (int i = 1; i <= 9; i++) {
                if (!(rowUsed[row][i] || colUsed[col][i] || boxUsed[row / 3][col/ 3][i])) {
                    rowUsed[row][i] = true;
                    colUsed[col][i] = true;
                    boxUsed[row / 3][col / 3][i] = true;
                    board[row][col] = (char)('0' + i);
                    if (recusiveSolveSudoku(board, rowUsed, colUsed, boxUsed, row, col + 1)) {
                        return true;
                    }
                    rowUsed[row][i] = false;
                    colUsed[col][i] = false;
                    boxUsed[row / 3][col / 3][i] = false;
                    board[row][col] = '.';
                }
            }

        } else {
            return recusiveSolveSudoku(board, rowUsed, colUsed, boxUsed, row, col + 1);
        }
        return false;
    }


    /**
     * DFS
     * @param board
     */
    public void solveSudokuRe(char[][] board) {
        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int position) {
        if (position == 81) return true;
        int x = position / 9;
        int y = position % 9;
        //prefill number skip
        if (board[x][y] != '.') return dfs(board, position + 1);
        boolean[] flag = new boolean[10];
        validate(board, x, y, flag);
        for (int i = 1; i <= 9; i++) {
            if (flag[i]) {
                board[x][y] =(char)('0' + i);
                if (dfs(board, position + 1)) return true;
            }
        }
        //if can not solve, in the wrong path, change back to '.' and out
        board[x][y] = '.';
        return false;
    }

    private void validate(char[][] board, int x, int y, boolean[] flag) {
        Arrays.fill(flag, true);
        for (int i = 0; i < 9; i++) {
            if (board[x][i] != '.') flag[board[x][i] - '0'] = false;
            if (board[i][y] != '.') flag[board[i][y] - '0'] = false;
            int r = (x / 3) * 3 + i / 3;
            int c = (y / 3) * 3 + i % 3;
            if (board[r][c] != '.') flag[board[r][c] - '0'] = false;

        }
    }




}