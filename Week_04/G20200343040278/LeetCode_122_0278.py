#
# @lc app=leetcode.cn id=122 lang=python3
#
# [122] 买卖股票的最佳时机 II
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res = 0
        if not prices:
            return 0
        p_length = len(prices)
        for i in range(1, p_length):
            if prices[i] > prices[i - 1]:
                res += prices[i] - prices[i - 1]
        return res


# @lc code=end

