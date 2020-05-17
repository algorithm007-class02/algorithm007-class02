package com.alang.learn.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *  
 * <p>
 * 提示：
 * <p>
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步，可进可退。（引用自 百度百科 - 皇后 ）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_51_0034 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
        System.out.println(solution.solveNQueens1(4));
    }

    static public class Solution {
        public List<List<String>> solveNQueens1(int n) {
            List<List<String>> result = new ArrayList<>();
            helper1(0, n, new boolean[n], new boolean[2 * n], new boolean[2 * n], new ArrayList<String>(), result);
            return result;
        }

        private void helper1(int row, int n, boolean[] cols, boolean[] d1, boolean[] d2, ArrayList<String> board, List<List<String>> res) {
            if (n == board.size()) res.add(new ArrayList<String>(board));
            else {
                for (int c = 0; c < n; c++) {
                    int id1 = n + row - c;//主对角线上 row-col 是常量
                    int id2 = row + c;//副对角线上 row+col 是常量
                    if (!cols[c] && !d1[id1] && !d2[id2]) {
                        cols[c] = true;
                        d1[id1] = true;
                        d2[id2] = true;
                        char[] chars = new char[n];
                        Arrays.fill(chars, '.');
                        chars[c] = 'Q';
                        board.add(String.valueOf(chars));
                        helper1(row + 1, n, cols, d1, d2, board, res);
                        cols[c] = false;
                        d1[id1] = false;
                        d2[id2] = false;
                        board.remove(board.size() - 1);
                    }
                }
            }
        }

        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            helper2(0, n, 0, 0, 0, new ArrayList<String>(), result);
            return result;
        }

        private void helper2(int row, int n, int cols, int d1, int d2, ArrayList<String> board, List<List<String>> res) {
            if (row == n) {
                res.add(new ArrayList<String>(board));
                return;
            }
            int pos = (~(cols | d1 | d2)) & ((1 << n) - 1);
            char[] chars = new char[n];
            while (pos != 0) {
                int value = pos & -pos;
                Arrays.fill(chars, '.');
                int index = 0;
                for (int i = 0; i < n; i++) {
                    if (value == (1 << i)) {
                        chars[i] = 'Q';
                        break;
                    }
                }
                board.add(String.valueOf(chars));
                helper2(row + 1, n, cols | value, (d1 | value) << 1, (d2 | value) >> 1, board, res);
                pos &= (pos - 1);
                board.remove(board.size() - 1);
            }
        }
    }
}
