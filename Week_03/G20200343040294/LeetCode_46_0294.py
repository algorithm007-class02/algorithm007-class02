#
# @lc app=leetcode.cn id=46 lang=python3
#
# [46] 全排列
# 迭代器：https://docs.python.org/3/library/itertools.html

# @lc code=start
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        import itertools
        return list(itertools.permutations(nums))

# @lc code=end

