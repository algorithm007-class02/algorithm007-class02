package Week_07.G20200343040246;

public class LeetCode_36_0246 {
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
        boolean ans = new LeetCode_36_0246().isValidSudoku(board);
        System.out.println(ans);
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9], cols = new int[9][9], box = new int[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (isRepeat(rows, i, num)) {
                        return false;
                    }
                    if (isRepeat(cols, j, num)) {
                        return false;
                    }
                    int bIdx = (i / 3) * 3 + j / 3;
                    if (isRepeat(box, bIdx, num)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isRepeat(int[][] nums, int idx, int num) {
        if (nums[idx][num - 1] == 1) return true;
        nums[idx][num - 1] = 1;
        return false;
    }
}