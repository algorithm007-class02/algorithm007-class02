class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        benefit = 0
        for i in range(1,len(prices)):
            if prices[i] > prices[i-1]:
                benefit += prices[i]-prices[i-1]
        return benefit
