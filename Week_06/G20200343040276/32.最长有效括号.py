#
# @lc app=leetcode.cn id=32 lang=python3
#
# [32] 最长有效括号
#

# @lc code=start
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack=[]
        for i,c in enumerate(s):
            if c==')' and stack and s[stack[-1]]=='(':
                stack.pop()
            else:
                stack.append(i)
        stack.append(len(s))
        max_length=stack[0]

        for index in range(1,len(stack)):
            max_length=max(max_length,stack[index]-stack[index-1]-1)
        
        return max_length
# @lc code=end

