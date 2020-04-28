# n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
# 
#  
# 
#  上图为 8 皇后问题的一种解法。 
# 
#  给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
# 
#  每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
# 
#  示例: 
# 
#  输入: 4
# 输出: [
#  [".Q..",  // 解法 1
#   "...Q",
#   "Q...",
#   "..Q."],
# 
#  ["..Q.",  // 解法 2
#   "Q...",
#   "...Q",
#   ".Q.."]
# ]
# 解释: 4 皇后问题存在两个不同的解法。
#  
#  Related Topics 回溯算法


# leetcode submit region begin(Prohibit modification and deletion)
"""
>>> Solution()._to_map([1, 3, 0, 2])
['.Q..', '...Q', 'Q...', '..Q.']
>>> Solution().solveNQueens(4)
[['.Q..', '...Q', 'Q...', '..Q.'], ['..Q.', 'Q...', '...Q', '.Q..']]
"""
from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        return [self._to_map(queues) for queues in self._solveNQueens(n, 0, [])]

    def _solveNQueens(self, n: int, row: int, queues: List[int]) -> List[List[int]]:
        if row == n:
            return [queues]

        result = []
        for col in range(n):
            if not self._will_attack(queues, row, col):
                result += self._solveNQueens(n, row + 1, queues[:] + [col])

        return result

    def _will_attack(self, queues, row, col):
        for q_row, q_col in enumerate(queues):
            if q_row == row or q_col == col or abs(row - q_row) == abs(col - q_col):
                return True
        return False

    def _to_map(self, queens: List[int]) -> List[str]:
        return ['.' * q + 'Q' + '.' * (len(queens) - q - 1) for q in queens]
# leetcode submit region end(Prohibit modification and deletion)
