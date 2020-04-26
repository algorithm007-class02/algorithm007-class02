package week07.g20200343040172;

import java.util.*;

/**
 * LeetCode_51_N皇后
 * https://leetcode-cn.com/problems/n-queens/
 */
public class LeetCode_51_0172 {

    class Solution1 {

        private List<List<String>> res;
        private int n;

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            res = new ArrayList<>();
            if (n == 0) {
                return res;
            }
            // 列
            int col = 0;
            int master = 0;
            int slave = 0;
            Stack<Integer> stack = new Stack<>();
            backtrack(0, col, master, slave, stack);
            return res;
        }

        private void backtrack(int row, int col, int master, int slave, Stack<Integer> stack) {
            if (row == n) {
                List<String> board = convert2board(stack, n);
                res.add(board);
                return;
            }

            // 针对每一列，尝试是否可以放置
            for (int i = 0; i < n; i++) {
                if (((col >> i) & 1) == 0
                        && ((master >> (row + i)) & 1) == 0
                        && ((slave >> (row - i + n - 1)) & 1) == 0) {
                    stack.add(i);
                    col ^= (1 << i);
                    master ^= (1 << (row + i));
                    slave ^= (1 << (row - i + n - 1));

                    backtrack(row + 1, col, master, slave, stack);

                    slave ^= (1 << (row - i + n - 1));
                    master ^= (1 << (row + i));
                    col ^= (1 << i);
                    stack.pop();
                }
            }
        }

        private List<String> convert2board(Stack<Integer> stack, int n) {
            List<String> board = new ArrayList<>();
            for (Integer num : stack) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    stringBuilder.append(".");
                }
                stringBuilder.replace(num, num + 1, "Q");
                board.add(stringBuilder.toString());
            }
            return board;
        }
    }

    class Solution2 {

        // 不生成 nums 数组，并且使用成员变量

        private Set<Integer> col;
        private Set<Integer> pie;
        private Set<Integer> la;
        private int n;
        private List<List<String>> res;

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            res = new ArrayList<>();
            if (n == 0) {
                return res;
            }

            col = new HashSet<>();
            pie = new HashSet<>();
            la = new HashSet<>();

            Stack<Integer> stack = new Stack<>();
            backtrack(0, stack);
            return res;
        }

        private void backtrack(int row, Stack<Integer> stack) {
            // row：行
            if (row == n) {
                List<String> board = convert2board(stack, n);
                res.add(board);
                return;
            }

            // 针对每一列，尝试是否可以放置
            for (int i = 0; i < n; i++) {
                if (!col.contains(i) && !pie.contains(row + i) && !la.contains(row - i)) {
                    stack.add(i);
                    col.add(i);
                    pie.add(row + i);
                    la.add(row - i);

                    backtrack(row + 1, stack);

                    la.remove(row - i);
                    pie.remove(row + i);
                    col.remove(i);
                    stack.pop();
                }
            }
        }

        private List<String> convert2board(Stack<Integer> stack, int n) {
            List<String> board = new ArrayList<>();
            for (Integer num : stack) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    stringBuilder.append(".");
                }
                stringBuilder.replace(num, num + 1, "Q");
                board.add(stringBuilder.toString());
            }
            return board;
        }
    }
}
