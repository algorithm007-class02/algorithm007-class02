#
# @lc app=leetcode.cn id=300 lang=python3
#
# [300] 最长上升子序列
#

# @lc code=start
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        ans = 0
        length = len(nums)
        dp = [1] * length
        for i in range(length):
            j = 0
            while j < i:
                if nums[i] > nums[j] and dp[j] + 1 > dp[i]:
                    dp[i] = dp[j] + 1 
                j += 1
            ans = max(ans, dp[i])
        return ans


# 动态规划
# dp[i]表示以A[i]结尾的最长上升子序列长度
# 如果存在A[i]之前的元素A[j]，使得A[j] <= A[i]且dp[j] + 1 > dp[i]，那么就把A[i]跟在A[j]的后面形成一条更长的上升子序列。
# 如果A[i]之前的元素都比A[j]大，那么A[i]只能自己形成一条LIS，dp[i] = 1。

# @lc code=end

