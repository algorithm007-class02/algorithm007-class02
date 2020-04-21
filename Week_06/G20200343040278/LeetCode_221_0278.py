#
# @lc app=leetcode.cn id=221 lang=python3
#
# [221] 最大正方形
#

# @lc code=start
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        m, n = len(matrix), len(matrix[0])
        maxNum = 0
        for i in range(m):
            for j in range(n):
                matrix[i][j] = int(matrix[i][j])
                if i >= 1 and j >= 1 and matrix[i][j] == 1:
                    matrix[i][j] = min(matrix[i - 1][j - 1], matrix[i][j - 1], matrix[i - 1][j]) + 1
                if matrix[i][j] > maxNum:
                    maxNum = matrix[i][j]
        return maxNum * maxNum

# str?????????????????????????????
# 动态规划的题目都好醉。。。

# @lc code=end

