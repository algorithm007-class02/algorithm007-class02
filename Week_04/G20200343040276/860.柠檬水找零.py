#
# @lc app=leetcode.cn id=860 lang=python3
#
# [860] 柠檬水找零
#

# @lc code=start
class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        dollor_5,dollor_10=0,0
        if bills[0]==10 or bills[0]==20:
            return False
        for i in bills:
            if i==5:
                dollor_5+=1
            elif i==10:
                dollor_10+=1
                if dollor_5>=1:
                    dollor_5-=1
                else:
                    return False
            elif i==20:
                if dollor_10>=1 and dollor_5>=1:
                    dollor_5-=1
                    dollor_10-=1
                elif dollor_5>=3 and dollor_10==0:
                    dollor_5-=3
                else:
                    return False
        return True
# @lc code=end

