package week03.g20200343040172;

/**
 * https://leetcode-cn.com/problems/available-captures-for-rook/
 * 每日一题
 * LeetCode-999 Available captures for rook
 */
public class LeetCode_999_0172 {
    public int numRookCaptures(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'R') {
                    if (findLeft(i, j, board) == true) {
                        count++;
                    }
                    if (findRight(i, j, board) == true) {
                        count++;
                    }
                    if (findUp(i, j, board) == true) {
                        count++;
                    }
                    if (findDown(i, j, board) == true) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int[] findRook(char[][] board) {
        if (board == null) {
            return null;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'R') {
                    int[] ans = {i, j};
                    return ans;
                }
            }
        }
        return null;
    }

    public boolean findLeft(int x, int y, char[][] board) {
        if (y == 0) {
            return false;
        }
        while (y != 0) {
            y--;
            if (board[x][y] == 'R') {
                return false;
            }
            if (board[x][y] == 'p') {
                return true;
            }
        }
        return false;
    }
    public boolean findRight(int x, int y, char[][] board) {
        if (y == board.length-1) {
            return false;
        }
        while (y != (board.length-1)) {
            y++;
            if (board[x][y] == 'R') {
                return false;
            }
            if (board[x][y] == 'p') {
                return true;
            }
        }
        return false;
    }

    public boolean findUp(int x, int y, char[][] board) {
        if (x == 0) {
            return false;
        }
        while (x != 0) {
            x--;
            if (board[x][y] == 'R') {
                return false;
            }
            if (board[x][y] == 'p') {
                return true;
            }
        }
        return false;
    }

    public boolean findDown(int x, int y, char[][] board) {
        if (x == board.length-1) {
            return false;
        }
        while (x != board.length-1) {
            x++;
            if (board[x][y] == 'R') {
                return false;
            }
            if (board[x][y] == 'p') {
                return true;
            }
        }
        return false;
    }

}
