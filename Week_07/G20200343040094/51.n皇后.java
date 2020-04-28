import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (68.72%)
 * Likes:    384
 * Dislikes: 0
 * Total Accepted:    36.5K
 * Total Submissions: 53K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: [
 * ⁠[".Q..",  // 解法 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // 解法 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 
 * 
 */

// @lc code=start
class Solution {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag1 = new HashSet<>();
    Set<Integer> diag2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        dfs(res, new LinkedList<>(), 0, n);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> tempList, int row, int n) {
        if (row == n) {
            res.add(new LinkedList<>(tempList));
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (cols.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) continue;
            
            char[] charArr = new char[n];
            Arrays.fill(charArr, '.');
            charArr[i] = 'Q';
            String rowStr = String.valueOf(charArr);
            
            tempList.add(rowStr);
            cols.add(i);
            diag1.add(row + i);
            diag2.add(row - i);

            dfs(res, tempList, row + 1, n);

            tempList.remove(tempList.size() - 1);
            cols.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }
    }
}
// @lc code=end

