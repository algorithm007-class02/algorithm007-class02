/*
 * 529 扫雷游戏
 */
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int nr = board.length;
        int nc = board[0].length;

        int row = click[0], col = click[1];
        if (board[row][col] == 'M' || board[row][col] == 'X') {
            board[row][col] = 'M';
            return board;
        }
        int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
        int num = 0;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < nr && newCol >= 0 && newCol < nc && board[newRow][newCol] == 'M') {
                num++;
            }
        }
        if (num > 0) {
            board[row][col] = (char) (num + '0');
            return board;
        }
        board[row][col] = 'B';
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < nr && newCol >= 0 && newCol < nc && board[newRow][newCol] == 'E') {
                int[] nextClick = { newRow, newCol };
                updateBoard(board, nextClick);
            }
        }
        return board;
    }
}