#
# @lc app=leetcode.cn id=32 lang=python3
#
# [32] 最长有效括号
#

# @lc code=start
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        maxnum = 0
        stack = [-1]
        for i in range(len(s)):
            if s[i] == "(": stack.append(i)
            else:
                stack.pop()
                if not stack: stack.append(i)
                if stack: maxnum = max(maxnum, i - stack[-1])
        return maxnum

# @lc code=end

