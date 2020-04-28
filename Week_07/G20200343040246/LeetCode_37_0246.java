package Week_07.G20200343040246;

public class LeetCode_37_0246 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','.'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'},
        };
        new LeetCode_37_0246().solveSudoku(board);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9], cols = new boolean[9][9], box = new boolean[9][9];
        if (isFullOrNotValid(board, rows, cols, box)) return;
        backtrack(board, 0, 0, rows, cols, box);
    }

    public boolean backtrack(char[][] board, int row, int col, 
            boolean[][] rows, boolean[][] cols, boolean[][] box) {
        if (col == 9) { 
            row++; 
            col = 0;
        }
        if (row == 9) {
            return true;
        }
        int boxIdx = (row / 3) * 3 + col / 3;
        if (board[row][col] == '.') {
            for(int n = 0; n < 9; n++) {
                if(rows[row][n] || cols[col][n] || box[boxIdx][n]) continue;
                board[row][col] = (char)(n + '1');
                rows[row][n] = true;
                cols[col][n] = true;
                box[boxIdx][n] = true;
                if (backtrack(board, row, col + 1, rows, cols, box)) return true;
                rows[row][n] = false;
                cols[col][n] = false;
                box[boxIdx][n] = false;
            }
            board[row][col] = '.';
        } else {
            return backtrack(board, row, col + 1, rows, cols, box);
        }
        return false;
    }
    
    public boolean isFullOrNotValid(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] box) {
        boolean isFull = true;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int n = board[row][col] - '1';
                    int boxIdx = (row / 3) * 3 + col / 3;
                    if (rows[row][n] || cols[col][n] || box[boxIdx][n]) {
                        return true;
                    }
                    rows[row][n] = true;
                    cols[col][n] = true;
                    box[boxIdx][n] = true;
                } else {
                    isFull = false;
                }
            }
        }
        return isFull;
    }
}