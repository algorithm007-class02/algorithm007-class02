#
# @lc app=leetcode.cn id=115 lang=python3
#
# [115] 不同的子序列
#

# @lc code=start
class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        dp=[1]*(len(s)+1)
        temp=[0]*(len(s)+1)
        for i in range(1,len(t)+1):
            match=0
            for j in range(1,len(s)+1):
                if s[j-1]==t[i-1]:
                    temp[j]=match+dp[j-1]
                else:
                    temp[j]=match
                match=temp[j]
            dp=temp.copy()
        return dp[-1]

        
# @lc code=end

