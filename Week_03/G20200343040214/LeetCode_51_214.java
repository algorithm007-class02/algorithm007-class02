package level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution51 {
    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        System.out.println(solution51.solveNQueens(4));
    }

    private List<Integer> cols;
    private List<Integer> pie;
    private List<Integer> na;
    private List<List<Integer>> result;

    public List<List<String>> solveNQueens(int n) {
        if (n < 1)
            return new ArrayList<>();
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder();
            str.append(".".repeat(n));
            board.add(str.toString());
        }
        this.cols = new ArrayList<>();
        this.pie = new ArrayList<>();
        this.na = new ArrayList<>();
        this.result = new ArrayList<>();
        dfs(0, n, new ArrayList<>());
        System.out.println(generate(n, board).toString());
        return null;
    }

    private void dfs(int row, int n, List<Integer> curr_state) {
        if (row >= n) {
            this.result.add(curr_state);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (this.cols.contains(col) || this.pie.contains(col + row) || this.na.contains(row - col))
                continue;
            this.cols.add(col);
            this.pie.add(col + row);
            this.na.add(row - col);
            List<Integer> state = new ArrayList<>(curr_state);
            state.add(col);
            this.dfs(row + 1, n, state);

            this.cols.remove(Integer.valueOf(col));
            this.pie.remove(Integer.valueOf(col + row));
            this.na.remove(Integer.valueOf(row - col));
        }
    }

    private List<List<String>> generate(int n, List<String> border) {
        List<List<String>> list = new ArrayList<>();
        for (List<Integer> cols : this.result) {
            List<String> strs = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int pos = cols.get(j);
                String line = border.get(j);
                char[] cs = line.toCharArray();
                cs[pos] = 'Q';
                strs.add(new String(cs));
            }
            list.add(strs);
        }
        return list;
    }

    // 国际解法
    // TODO 重点理解的解题方法 二刷
    public List<List<String>> solveNQueens2(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, res);
        return res;
    }

    private static void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if (colIndex == board.length) {
            res.add(construct(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }

    private static boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                // na pie 列
                if (board[i][j] == 'Q' && (x - y == i - j || x + y == i + j || x == i))
                    return false;
            }
        }

        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }
        return res;
    }
}
