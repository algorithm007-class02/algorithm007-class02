#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] 岛屿数量
#

# @lc code=start
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        cnt = 0
        n = len(grid)
        if n == 0: 
            return 0
        m = len(grid[0])
        def DFSMarking(grid, i, j):
            if i < 0 or j < 0 or i >= n or j >= m or grid[i][j] != '1':
                return
            grid[i][j] = '0'
            DFSMarking(grid, i+1, j)
            DFSMarking(grid, i-1, j)
            DFSMarking(grid, i, j+1)
            DFSMarking(grid, i, j-1)

        for i in range(n):
            for j in range(m):
                if grid[i][j] == '1':
                    DFSMarking(grid, i, j)
                    cnt += 1
        return cnt

# @lc code=end

