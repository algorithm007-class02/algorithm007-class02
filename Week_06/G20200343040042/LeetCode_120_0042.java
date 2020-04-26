package com.yequan.leetcode.dp.minimumTotal_120;

import java.util.List;

/**
 * //给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * //
 * // 例如，给定三角形：
 * //
 * // [
 * //     [2],
 * //    [3,4],
 * //   [6,5,7],
 * //  [4,1,8,3]
 * //]
 * //
 * //
 * // 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * //
 * // 说明：
 * //
 * // 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * // Related Topics 数组 动态规划
 *
 * @author : Administrator
 * @date : 2020/4/19
 */
public class MinimumTotal {

    /**
     * 动态规划: 自定向下法
     * dp[i][j]表示到达当前位置的最小路径和
     * 首先dp[0][0] = triangle.get(0).get(0)
     * 从第二行开始:
     * 分三种情况:
     * 1.当在最左侧时: dp[i][j] = dp[i-1][j] + triangle.get(i).get(j): 只能从右上角下来
     * 2.当在最右侧时: dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j): 只能从左上角下来
     * 3.当在中间时: dp[i][j] = Min(dp[i-1][j-1] , dp[i-1][j]) + triangle.get(i).get(j): 可以从左上角和右上角下来,取最小
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int column = triangle.get(row - 1).size();
        int[][] dp = new int[row][column];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < column; i++) {
            ans = Math.min(dp[row - 1][i], ans);
        }
        return ans;
    }

}
