# 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
# 
#  说明：每次只能向下或者向右移动一步。 
# 
#  示例: 
# 
#  输入:
# [
#   [1,3,1],
#   [1,5,1],
#   [4,2,1]
# ]
# 输出: 7
# 解释: 因为路径 1→3→1→1→1 的总和最小。
#  
#  Related Topics 数组 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
"""
>>> Solution().minPathSum([
...     [1, 3, 1],
...     [1, 5, 1],
...     [4, 2, 1]
... ])
7
>>> Solution().minPathSum([
...     [1, 3, 1]
... ])
5
>>> Solution().minPathSum([
...     [1]
... ])
1
>>> Solution2().minPathSum([
...     [1, 3, 1],
...     [1, 5, 1],
...     [4, 2, 1]
... ])
7
>>> Solution2().minPathSum([
...     [1, 3, 1]
... ])
5
>>> Solution2().minPathSum([
...     [1]
... ])
1
"""
from functools import lru_cache
from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        for i in range(1, n):
            grid[0][i] += grid[0][i - 1]

        for j in range(1, m):
            grid[j][0] += grid[j - 1][0]

        for i in range(1, m):
            for j in range(1, n):
                grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])

        return grid[m - 1][n - 1]


class Solution2:
    def minPathSum(self, grid: List[List[int]]) -> int:
        @lru_cache(maxsize=None)
        def _minPathSum(m, n):
            if m == len(grid) - 1 and n == len(grid[m]) - 1:
                return grid[m][n]
            elif m == len(grid) - 1:
                return grid[m][n] + _minPathSum(m, n + 1)
            elif n == len(grid[m]) - 1:
                return grid[m][n] + _minPathSum(m + 1, n)
            else:
                return grid[m][n] + min(
                    _minPathSum(m + 1, n),
                    _minPathSum(m, n + 1)
                )

        return _minPathSum(0, 0)
# leetcode submit region end(Prohibit modification and deletion)
