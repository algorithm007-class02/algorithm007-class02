#
# @lc app=leetcode.cn id=860 lang=python3
#
# [860] 柠檬水找零
#

# @lc code=start
class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        st5 = 0
        st10 = 0
        for n in bills:
            if n == 5:
                st5 += 1
            elif n == 10:
                st5 -= 1
                st10 += 1
            elif st10 == 0:
                st5 -= 3
            else:
                st10 -= 1
                st5 -= 1
            if st5 < 0 or st10 < 0:
                return False
        return True 

# @lc code=end

