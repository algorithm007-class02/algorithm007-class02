//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2: 
//
// 输入: [2,7,9,3,1]
//输出: 12
//解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
// Related Topics 动态规划


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
//        int[] dp = new int[n + 2];
        int dp_i_1 = 0,dp_i_2 = 0;
        int dp_i = 0;
        for (int i = n - 1; i >= 0; i--) {
//            dp[i] = Math.max(dp[i + 1],nums[i] + dp[i + 2]);
            dp_i = Math.max(dp_i_1,nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
//        return dp[0];
        return dp_i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * private int[] cache;
 *     public int rob(int[] nums) {
 *         if (nums.length == 0 || nums == null) return 0;
 *         cache = new int[nums.length];
 *         Arrays.fill(cache,-1);
 *         return dp(nums,0);
 *     }
 *     int dp(int[] nums,int index) {
 *         if (index >= nums.length) return 0;
 *         if (cache[index] != -1) return cache[index];
 *         int res = Math.max(dp(nums,index + 1),nums[index] + dp(nums,index + 2));
 *         cache[index] = res;
 *         return res;
 *     }
 */
