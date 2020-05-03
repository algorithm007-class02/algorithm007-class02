public class LeetCode_36_0222 {

    /**
     * 时间复杂度为O(1) 空间复杂度为O(1) 因为大小已定
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                row[i][num]++;
                col[j][num]++;
                box[(i / 3) * 3 + (j / 3)][num]++;
                if (row[i][num] + col[j][num] + box[(i / 3) * 3 + (j / 3)][num] > 3) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 位运算  时间复杂度为O(1) 空间复杂度为O(1) 因为大小已定
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int curI = 0, curJ = 0, curBox = 0;
            for (int j = 0; j < board[0].length; j++) {
                int row = board[i][j] - 48;
                int col = board[j][i] - 48;
                int box = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3] - 48;
                if (row > 0) {
                    curI = sodokuer(row, curI);
                }
                if (col > 0) {
                    curJ = sodokuer(col, curJ);
                }
                if (box > 0) {
                    curBox = sodokuer(box, curBox);
                }
                if (curBox == -1 || curJ == -1 || curI == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    private int sodokuer(int n , int val) {
        return ((val >> n) & 1) == 1 ? - 1 : val ^ (1 << n);
    }


}