/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子序列
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (37.46%)
 * Likes:    464
 * Dislikes: 0
 * Total Accepted:    45.6K
 * Total Submissions: 120.8K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * 
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxProduct = nums[0];
        int tempMax = nums[0];
        int tempMin = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < 0) {
                int tmp = tempMax;
                tempMax = tempMin;
                tempMin = tmp;
            }
            tempMax = Math.max(tempMax * nums[i], nums[i]);
            tempMin = Math.min(tempMin * nums[i], nums[i]);
            maxProduct = Math.max(maxProduct, tempMax);
        }
        return maxProduct;
    }
}
// @lc code=end
