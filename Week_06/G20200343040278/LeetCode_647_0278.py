#
# @lc app=leetcode.cn id=647 lang=python3
#
# [647] 回文子串
#

# @lc code=start
class Solution:
    def countSubstrings(self, s: str) -> int:
        if not s:
            return 0
        n = len(s)
        cnt = 0
        for i in range(n):
            for j in range(i, n):
                if (i == 0 and s[i:j + 1] == s[j::-1]) or (i != 0 and s[i:j + 1] == s[j:i - 1:-1]):
                    cnt += 1
        return cnt

# 初见思路1：暴力法
# 计算复杂度O(n^2) 

# @lc code=end

