/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 *
 * https://leetcode-cn.com/problems/maximal-rectangle/description/
 *
 * algorithms
 * Hard (45.07%)
 * Likes:    415
 * Dislikes: 0
 * Total Accepted:    27.4K
 * Total Submissions: 59.6K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * ⁠ ["1","0","1","0","0"],
 * ⁠ ["1","0","1","1","1"],
 * ⁠ ["1","1","1","1","1"],
 * ⁠ ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * 
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int[] leftBoundary = new int[n];
        int[] rightBoundary = new int[n];
        Arrays.fill(rightBoundary, n);
        int res = 0;
        for (int i = 0; i < m; ++i) {
            int cur_left = 0, cur_right = n;
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1')
                    leftBoundary[j] = Math.max(leftBoundary[j], cur_left);
                else {
                    leftBoundary[j] = 0;
                    cur_left = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; --j) {
                if (matrix[i][j] == '1')
                    rightBoundary[j] = Math.min(rightBoundary[j], cur_right);
                else {
                    rightBoundary[j] = n;
                    cur_right = j;
                }
            }
            for (int j = 0; j < n; ++j) {
                res = Math.max(res, (rightBoundary[j] - leftBoundary[j]) * height[j]);
            }
        }
        return res;
    }
}
// @lc code=end
