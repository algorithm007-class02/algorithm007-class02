package com.yequan.leetcode.dp.maxProduct_152;

/**
 * //给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * // 输入: [2,3,-2,4]
 * //输出: 6
 * //解释: 子数组 [2,3] 有最大乘积 6。
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: [-2,0,-1]
 * //输出: 0
 * //解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * // Related Topics 数组 动态规划
 *
 * @author : Administrator
 * @date : 2020/4/19
 */
public class MaxProduct {

    /**
     * 动态规划
     * 用两个一维数组存储状态:
     * dpMin[i]: i之前数的最小乘积, 如果dpMin[i-1]为负数,且i也为负数,则 i 位置的最大乘积为 两者相乘
     * dpoMax[i]: i之前的最小乘积, 如果dpMax[i-1]位正数,且i也为正数, 则 i 位置的最大乘积为 两者相乘
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] dpMin = new int[length];
        int[] dpMax = new int[length];

        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        int product = nums[0];
        for (int i = 1; i < length; i++) {
            dpMax[i] = Math.max(Math.max(dpMax[i - 1] * nums[i], nums[i]), dpMin[i - 1] * nums[i]);
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(dpMax[i - 1] * nums[i], nums[i]));
            product = Math.max(product, dpMax[i]);
        }
        return product;
    }

}
