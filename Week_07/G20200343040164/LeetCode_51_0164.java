//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<String>> output = new ArrayList<>();
    int[] rows;
    int[] mains;
    int[] secondary;
    int[] queens;
    int n;
    public List<List<String>> solveNQueens(int n) {
        rows = new int[n];
        mains = new int[2 * n - 1];
        secondary = new int[2 * n - 1];
        queens = new int[n];
        this.n = n;

        backtrack(0);
        return output;
    }
    void backtrack(int row) {
        if (row >= n) return;
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row,col)) {
                placeQueen(row, col);
                if (row == n - 1)addSolution();
                backtrack(row + 1);
                removeQueen(row, col);
            }
        }
    }
    boolean isNotUnderAttack(int row, int col) {
        int res = rows[col] + mains[row - col + n - 1] + secondary[row + col];
        return res == 0;
    }
    void placeQueen(int row,int col) {
        queens[row] = col;
        rows[col] = 1;
        mains[row - col + n - 1] = 1;
        secondary[row + col] = 1;
    }
    void removeQueen(int row,int col) {
        queens[row] = 0;
        rows[col] = 0;
        mains[row - col + n - 1] = 0;
        secondary[row + col] = 0;
    }
    void addSolution() {
        List<String> solution = new ArrayList<>();
        for ( int i = 0; i < n; i++ ) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for ( int j = 0; j < col; j++ ) sb.append(".");
            sb.append("Q");
            for ( int k = 0; k < n - col - 1; k++ ) sb.append(".");
            solution.add(sb.toString());
        }
        output.add(solution);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
