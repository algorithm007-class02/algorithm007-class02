#
# @lc app=leetcode.cn id=77 lang=python3
#
# [77] 组合
# 迭代器

# @lc code=start
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        import itertools
        return list(itertools.combinations(range(1,n+1),k))

# @lc code=end

