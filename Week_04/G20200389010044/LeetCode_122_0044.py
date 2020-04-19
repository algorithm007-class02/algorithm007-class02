# 1. 单次遍历法
#       可以完成多次交易，但不能同时处理多笔交易
#       可以证明，找到涨跌折线中所有上升的线段，其和为最大利润

# 2. 单次遍历优化
#       直接遍历，如果单日涨则买，单日跌则不买，所有的涨之和即为最大利润
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
            # # 单次遍历
            # res = 0
            # i = 0
            # while i < len(prices) - 1:
            #     for j in range(i+1, len(prices)):
            #         if prices[j] >= prices[j-1]:
            #             continue
            #         else:
            #             res += prices[j-1] - prices[i]
            #             i = j
            #             break
            #     else:
            #         res += prices[j] - prices[i]
            #         i = j
            #         break
            # return res

            # 单次遍历优化
            res = 0
            for i in range(1, len(prices)):
                tmp = prices[i] - prices[i-1]
                if tmp > 0:
                    res += tmp
            return res