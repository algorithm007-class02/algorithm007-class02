#
# @lc app=leetcode.cn id=91 lang=python3
#
# [91] 解码方法
#

# @lc code=start
class Solution:
    def numDecodings(self, s: str) -> int:
        if s == '':
            return 0
        dp = [1] if s[0] != '0' else [0]
        for i in range(1, len(s)):
            if s[i] != '0':
                if s[i - 1] == '1' or (s[i - 1] == '2' and s[i] <= '6'):
                    dp.append(dp[i - 1] + dp[i - 2])
                else:
                    dp.append(dp[i - 1])
            else:
                if s[i - 1] == '1' or s[i - 1] == '2':
                    dp.append(dp[i - 2])
                else:
                    return 0
        return dp[len(s) - 1]


# @lc code=end

