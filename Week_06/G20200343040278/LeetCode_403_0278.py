#
# @lc app=leetcode.cn id=403 lang=python3
#
# [403] 青蛙过河
#

# @lc code=start
class Solution:
    def canCross(self, stones: List[int]) -> bool:
        dp = dict()
        for s in stones:
            dp.setdefault(s, set())
        dp.get(0).add(0)
        for s in stones:
            for pre_step in dp.get(s):
                for step in [pre_step - 1, pre_step, pre_step + 1]:
                    if step > 0 and (s + step) in dp:
                        dp.get(s + step).add(step)
        return len(dp.get(stones[-1])) > 0
        
# @lc code=end

