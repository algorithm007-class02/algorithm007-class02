class Solution:
    def coinChange(self, coins: list, amount: int) -> int:
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0

        for i in range(1, amount + 1):
            for j in range(len(coins)):
                if i >= coins[j]:
                    dp[i] = min(dp[i], dp[i - coins[j]] + 1)

        return -1 if dp[-1] == amount + 1 else dp[-1]


# if __name__ == '__main__':
#     coins = [1, 2, 5]
#     amount = 11
#     solution = Solution()
#     res = solution.coinChange(coins, amount)
#     print(res)
