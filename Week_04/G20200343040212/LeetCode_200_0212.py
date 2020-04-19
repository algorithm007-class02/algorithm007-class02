# 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
# 网格的四个边均被水包围。 
# 
#  示例 1: 
# 
#  输入:
# 11110
# 11010
# 11000
# 00000
# 
# 输出: 1
#  
# 
#  示例 2: 
# 
#  输入:
# 11000
# 11000
# 00100
# 00011
# 
# 输出: 3
#  
#  Related Topics 深度优先搜索 广度优先搜索 并查集
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        n = len(grid)
        if n == 0:
            return 0
        m = len(grid[0])

        def dfs_masking(row, col):
            if row < 0 or col < 0 or row >= n or col >= m or grid[row][col] != '1':
                return
            grid[row][col] = '0'
            dfs_masking(row + 1, col)
            dfs_masking(row - 1, col)
            dfs_masking(row, col + 1)
            dfs_masking(row, col - 1)

        for i in range(n):
            for j in range(m):
                if grid[i][j] == '1':
                    dfs_masking(i, j)
                    count += 1
        return count

# leetcode submit region end(Prohibit modification and deletion)
