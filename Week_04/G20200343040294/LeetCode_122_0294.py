#
# @lc app=leetcode.cn id=122 lang=python3
#
# [122] 买卖股票的最佳时机 II
# 贪心算法

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        for i in range(1, len(prices)):
            temp = prices[i] - prices[i - 1]
            if temp > 0: profit += temp
        return profit
# @lc code=end

