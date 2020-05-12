package com.leetcode.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 51. N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，
 * 并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.'
 * 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class L51NQueues {

    List<List<String>> result = new ArrayList<>();
    Set<Integer> columnSet = new HashSet<>();
    Set<Integer> pieSet = new HashSet<>();
    Set<Integer> naSet = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return result;
        }

        int[][] board = new int[n][n];
        dfs(board, 0);

        return result;
    }

    void dfs(int[][] board, int row) {
        if (row >= board.length) {
            result.add(genResult(board));
            return;
        }

        int[] aRow = board[row];
        for (int column = 0; column < board.length; column++) {
            if (columnSet.contains(column) ||
                pieSet.contains(row + column) ||
                naSet.contains(row - column)) {
                continue;
            }

            setQueue(aRow, row, column);
            dfs(board, row + 1);
            unSetQueue(aRow, row, column);
        }
    }

    private void setQueue(int[] aRow,int row, int column) {
        aRow[column] = 1;
        columnSet.add(column);
        pieSet.add(row + column);
        naSet.add(row - column);
    }

    private void unSetQueue( int[] aRow,int row, int column) {
        aRow[column] = 0;
        columnSet.remove(column);
        pieSet.remove(row + column);
        naSet.remove(row - column);
    }

    private List<String> genResult(int[][] board) {
        List<String> list = new ArrayList<>();
        for (int[] ints : board) {
            StringBuilder builder = new StringBuilder();
            for (int anInt : ints) {
                builder.append(anInt == 0 ? "." : "Q");
            }
            list.add(builder.toString());
        }
        return list;
    }
}
