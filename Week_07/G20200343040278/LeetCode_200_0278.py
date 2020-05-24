#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] 岛屿数量
#

# @lc code=start
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        res = 0
        if not grid:
            return 0
        m, n = len(grid), len(grid[0])
        def DFSMarking(grid, i, j):
            if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] == '0':
                return
            grid[i][j] = '0'
            DFSMarking(grid, i-1, j) 
            DFSMarking(grid, i+1, j) 
            DFSMarking(grid, i, j-1) 
            DFSMarking(grid, i, j+1) 
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    res += 1
                    DFSMarking(grid, i, j)
        return res
# @lc code=end

