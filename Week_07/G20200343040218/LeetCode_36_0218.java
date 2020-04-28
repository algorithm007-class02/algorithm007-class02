class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] blocks = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int n = (int)board[i][j] - (int)('1');

                if (rows[i][n] != 0){
                    return false;
                } else {
                    rows[i][n] = 1;
                }

                if (columns[j][n] != 0){
                    return false;
                } else {
                    columns[j][n] = 1;
                }

                int bI = i / 3 + 3 * (j / 3);
                if (blocks[bI][n] != 0){
                    return false;
                } else {
                    blocks[bI][n] = 1;
                }
            }
        }
        return true;
    }
}