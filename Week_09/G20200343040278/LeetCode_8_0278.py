#
# @lc app=leetcode.cn id=8 lang=python3
#
# [8] 字符串转换整数 (atoi)
#

# @lc code=start
class Solution:
    def myAtoi(self, str: str) -> int:
        import re
        matches = re.match('[ ]*([+-]?\d+)', str)  
        if matches:
            res = int(matches.group(1))
            MAX = 2 ** 31 - 1
            MIN = -2 ** 31
            if res > MAX:
                return MAX
            elif res < MIN:
                return MIN
            else:
                return res
        else:
            return 0

            
# @lc code=end

