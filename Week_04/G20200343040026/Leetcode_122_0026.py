# 贪心法
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) <=1 :
            return 0
        res = 0
        i = 1
        while i < len(prices):
            res += prices[i]-prices[i-1] if prices[i] > prices[i-1] else 0
            i += 1
        return res