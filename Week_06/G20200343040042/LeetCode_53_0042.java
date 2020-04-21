package com.yequan.leetcode.dp.maxSubArray_53;

/**
 * //给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * //
 * // 示例:
 * //
 * // 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * //输出: 6
 * //解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * //
 * //
 * // 进阶:
 * //
 * // 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * // Related Topics 数组 分治算法 动态规划
 *
 * @author : Administrator
 * @date : 2020/4/19
 */
public class MaxSubArray {

    /**
     * 动态规划: 从左到右
     * 用 int[] dp 来记录前 i 个数中最大和
     * 首先nums[0]的最大和子数组为它本身: dp[0] = nums[0]
     * 往后第 i 个数的最大和为: 比较前i个数的最大和加上当前数 与 当前数,求最大: dp[i] = Max(dp[i-1]+nums[i],nums[i])
     * 取出dp中最大的数
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
