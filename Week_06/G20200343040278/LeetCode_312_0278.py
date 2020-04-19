#
# @lc app=leetcode.cn id=312 lang=python3
#
# [312] 戳气球
#

# @lc code=start
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        nums = [1] + nums + [1]
        n = len(nums)
        dp = [[0] * n for _ in range(n)]
        for step in range(2, n):
            for i in range(n):
                if step == 2:
                    if i + step < n:
                        dp[i][i+step] = nums[i] * nums[i+1] * nums[i+2]
                    continue
                for k in range(i+1, i+step):
                    if i + step < n:
                        dp[i][i + step] = max(dp[i][k] + dp[k][i + step] + nums[i] * nums[k] * nums[i + step], dp[i][i + step])
        return dp[0][n - 1]


        
# @lc code=end

