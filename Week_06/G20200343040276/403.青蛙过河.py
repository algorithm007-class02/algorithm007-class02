#
# @lc app=leetcode.cn id=403 lang=python3
#
# [403] 青蛙过河
#

# @lc code=start
class Solution:
    def canCross(self, stones: List[int]) -> bool:
        jumps={}
        for stone in stones:
            jumps[stone]=set()
        jumps[0].add(0)
        
        for stone in stones:
            for jump in jumps[stone]:
                for shift in [-1,0,1]:
                    if jump+shift>0 and stone+jump+shift in jumps:
                        jumps[stone+jump+shift].add(jump+shift)
        return bool(jumps[stones[-1]])
# @lc code=end

