#
# @lc app=leetcode.cn id=66 lang=python3
#
# [66] 加一
#

# @lc code=start
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        num = 0
        for digit in digits:
            num = num * 10 + digit
        num += 1
        result = []
        while num != 0:
            result.append(num % 10)
            num //= 10
        result.reverse()
        return result

# 初见思路1：
# list -> int -> list 时间复杂度O(n)


# @lc code=end

