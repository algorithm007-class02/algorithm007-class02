import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
    private List<List<String>> res = new LinkedList<>();
    private Set<Integer> colSet = new HashSet<>();
    private Set<Integer> pieSet = new HashSet<>();
    private Set<Integer> naSet = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars: board) Arrays.fill(chars, '.');
        backtrack(board, 0);
        return res;
    }
    private void backtrack(char[][] board, int row){
        if(row == board.length){
            res.add(charToString(board));
            return;
        }
        for (int col = 0; col < board[row].length; col++){
            if(!isValid(board, row, col)) continue;
            updateRecords(board, row, col);
            backtrack(board, row + 1);
            updateRecords(board, row, col);
        }
    }
    private void updateRecords(char[][] board, int row, int col){
        if(colSet.contains(col)){
            board[row][col] = '.';
            colSet.remove(col);
            naSet.remove(row - col);
            pieSet.remove(row + col);
        }else {
            board[row][col] = 'Q';
            colSet.add(col);
            naSet.add(row - col);
            pieSet.add(row + col);
        }
    }
    private boolean isValid(char[][] board, int row, int col){
        return !colSet.contains(col) && !naSet.contains(row-col) && !pieSet.contains(row+col);
    }
    private List<String> charToString(char[][] array){
        List<String> res = new LinkedList<>();
        for (char[] chars: array){
            res.add(String.valueOf(chars));
        }
        return res;
    }
}
// @lc code=end

