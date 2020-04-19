package com.yequan.leetcode.dp.rob_198;

/**
 * //你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
 * //被小偷闯入，系统会自动报警。
 * //
 * // 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * //
 * // 示例 1:
 * //
 * // 输入: [1,2,3,1]
 * //输出: 4
 * //解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * //     偷窃到的最高金额 = 1 + 3 = 4 。
 * //
 * // 示例 2:
 * //
 * // 输入: [2,7,9,3,1]
 * //输出: 12
 * //解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * //     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * //
 * // Related Topics 动态规划
 *
 * @author : Administrator
 * @date : 2020/4/19
 */
public class Rob {

    /**
     * 动态规划
     * 每一家都有两种状态, 偷, 不偷, 则求最大收益:
     * 第i家不偷: 比较前一家偷与不偷的收益
     * 第i家偷: 前一家肯定不能偷+第i家收益
     * int[][] dp 表示第i家的收益,第二维表示偷与不偷的状态, 0:不偷  1:偷
     * dp[i][0] = Max(dp[i-1][0],dp[i-1][i])
     * dp[i][1] = dp[i-1][0]+num[i]
     *
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        int ans = Math.max(dp[0][0], dp[0][1]);
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }

    /**
     * 动态规划
     * 求第i家的收益 = max(前一天偷的收益,(前两天偷的收益+第i天的收益))
     * dp[i] = max(dp[i-1],dp[i-2]+nums[i])
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int ans = Math.max(dp[0], dp[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
