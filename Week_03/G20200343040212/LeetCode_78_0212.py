# 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
#
#  说明：解集不能包含重复的子集。
#
#  示例:
#
#  输入: nums = [1,2,3]
# 输出:
# [
#   [3],
#   [1],
#   [2],
#   [1,2,3],
#   [1,3],
#   [2,3],
#   [1,2],
#   []
# ]
#  Related Topics 位运算 数组 回溯算法
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def __init__(self):
        self.result = []

    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.dfs([], 0, nums)
        return self.result

    def dfs(self, tmp, index, nums):
        # recursion terminator
        if index == len(nums):
            self.result.append(tmp)
            return

        self.dfs(tmp + [nums[index]], index + 1, nums)
        self.dfs(tmp, index + 1, nums)

# leetcode submit region end(Prohibit modification and deletion)
