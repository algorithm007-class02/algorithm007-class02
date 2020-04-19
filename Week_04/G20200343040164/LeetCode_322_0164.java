//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int result = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins,coins.length - 1,amount,0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    void dfs(int[] coins,int index,int amount,int count) {
        if (index < 0) return;
        for (int c = amount / coins[index]; c >= 0; c--) {
            int diff = amount - c * coins[index];
            int diffCount = count + c;
            if (diff == 0) {
                result = Math.min(result,diffCount);
                break;
            }
            if (diffCount + 1 >= result) break;
            dfs(coins,index - 1,diff,diffCount);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
