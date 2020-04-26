package week07.g20200343040172;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode_36_有效的数独
 * https://leetcode-cn.com/problems/valid-sudoku/
 */
public class LeetCode_36_0172 {

    /**
     * 使用HashMap
     */
    class Solution1 {
        public boolean isValidSudoku(char[][] board) {
            // init data
            HashMap<Integer, Integer>[] rows = new HashMap[9];
            HashMap<Integer, Integer>[] columns = new HashMap[9];
            HashMap<Integer, Integer>[] boxes = new HashMap[9];

            for (int i = 0; i < 9; i++) {
                rows[i] = new HashMap<Integer, Integer>();
                columns[i] = new HashMap<Integer, Integer>();
                boxes[i] = new HashMap<Integer, Integer>();
            }

            // validate a board
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char num = board[i][j];
                    if (num != '.') {
                        int n = (int) num;
                        int box_index = (i / 3) * 3 + j / 3;

                        // keep the current cell value
                        rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                        columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                        boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                        // check if this value has been already seen before
                        if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    /*****************************************************/

    /**
     * 使用数组
     */
    class Solution2 {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                boolean[] rowCheck = new boolean[9];
                boolean[] colCheck = new boolean[9];
                boolean[] boxCheck = new boolean[9];

                for (int j = 0; j < 9; j++) {
                    // 注意：一个是board[i][j]，一个是board[j][i]，另一个则是board[m][n]代表的意思均不一样
                    if (board[i][j] == '.') {
                    } else if (rowCheck[board[i][j] - '1']) {
                        return false;
                    } else {
                        rowCheck[board[i][j] - '1'] = true;
                    }

                    if (board[j][i] == '.') {
                    } else if (colCheck[board[j][i] - '1']) {
                        return false;
                    } else {
                        colCheck[board[j][i] - '1'] = true;
                    }

                    int m = i / 3 * 3 + j / 3;
                    int n = i % 3 * 3 + j % 3;
                    if (board[m][n] == '.') {
                    } else if (boxCheck[board[m][n] - '1']) {
                        return false;
                    } else {
                        boxCheck[board[m][n] - '1'] = true;
                    }
                }
            }
            return true;
        }
    }

    /*****************************************************/

    /**
     * 使用一个Set来存
     */
    class Solution3 {
        public boolean isValidSudoku(char[][] board) {
            Set<String> seen = new HashSet<>();
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    char number = board[i][j];
                    if (number != '.') {
                        if (!seen.add(number + " in row " + i) ||
                                !seen.add(number + " in column " + j) ||
                                !seen.add(number + " in block " + i / 3 + "-" + j / 3)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}
