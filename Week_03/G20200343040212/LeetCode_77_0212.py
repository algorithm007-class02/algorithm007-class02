# 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
#
#  示例:
#
#  输入: n = 4, k = 2
# 输出:
# [
#   [2,4],
#   [3,4],
#   [2,3],
#   [1,2],
#   [1,3],
#   [1,4],
# ]
#  Related Topics 回溯算法

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def __init__(self):
        self.result = []
        self.limit = 0
        self.nums = []

    def combine(self, n: int, k: int) -> List[List[int]]:
        self.limit = k
        self.nums = [i for i in range(1, n + 1)]
        self._generate([], 0)
        return self.result

    def _generate(self, current, index):
        # terminator
        if len(current) == self.limit:
            self.result.append(current)
            return
        if index == len(self.nums):
            return

        self._generate(current + [self.nums[index]], index + 1)
        self._generate(current, index + 1)

# leetcode submit region end(Prohibit modification and deletion)
