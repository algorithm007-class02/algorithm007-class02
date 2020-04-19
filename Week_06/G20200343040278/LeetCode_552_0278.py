#
# @lc app=leetcode.cn id=552 lang=python3
#
# [552] 学生出勤记录 II
#

# @lc code=start
class Solution:
    def checkRecord(self, n: int) -> int:
        M = 1000000007
        dp = [0] * (6 if n <= 5 else n + 1)
        dp[0] = 1
        dp[1] = 2
        dp[2] = 4
        dp[3] = 7
        for i in range(4, n + 1):
            dp[i] = ((2 * dp[i - 1]) % M + (M - dp[i - 4])) % M
        sum = dp[n]
        for i in range(1, n + 1):
            sum += (dp[i - 1] * dp[n - i]) % M
        return sum % M

        
# @lc code=end

