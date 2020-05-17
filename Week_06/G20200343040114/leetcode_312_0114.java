/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 *
 * https://leetcode-cn.com/problems/burst-balloons/description/
 *
 * algorithms
 * Hard (58.11%)
 * Likes:    272
 * Dislikes: 0
 * Total Accepted:    11.6K
 * Total Submissions: 19.5K
 * Testcase Example:  '[3,1,5,8]'
 *
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的
 * left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * 
 * 求所能获得硬币的最大数量。
 * 
 * 说明:
 * 
 * 
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * 
 * 示例:
 * 
 * 输入: [3,1,5,8]
 * 输出: 167 
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] data = new int[n];
        int[][] memo = new int[n][n];
        for (int i = 0; i < nums.length; i++) {
            data[i + 1] = nums[i];
        }
        data[0] = data[n - 1] = 1;
        return dp(data, memo, 0, n - 1);
    }

    private int dp(int[] data, int[][] memo, int left, int right) {
        if (left + 1 == right)
            return 0;
        int ans = 0;
        if (memo[left][right] > 0)
            return memo[left][right];
        for (int i = left + 1; i < right; i++) {
            ans = Math.max(ans,
                    data[left] * data[i] * data[right] + dp(data, memo, left, i) + dp(data, memo, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }
}
// @lc code=end
