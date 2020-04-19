# 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
#
#  示例:
#
#  输入: [1,2,3]
# 输出:
# [
#   [1,2,3],
#   [1,3,2],
#   [2,1,3],
#   [2,3,1],
#   [3,1,2],
#   [3,2,1]
# ]
#  Related Topics 回溯算法

from typing import List
import itertools


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    # cheat
    # def permute(self, nums: List[int]) -> List[List[int]]:
    #     return list(itertools.permutations(nums))

    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []

        def recursion(tmp, nums):
            if not nums:
                result.append(tmp)
                return None
            for i in range(len(nums)):
                recursion(tmp + [i], nums[:i] + nums[i + 1:])

        recursion([], nums)
        return result

# leetcode submit region end(Prohibit modification and deletion)
