# DFS
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid)==0 or len(grid[0])==0:
            return 0
        dx = [0, 0, -1, 1]
        dy = [1, -1, 0, 0]
        res = 0
        m, n = len(grid), len(grid[0])

        def findland(x, y):
            if grid[x][y] == '1':
                grid[x][y] = '0'
                for k in range(4):
                    nx = x+dx[k]
                    ny = y+dy[k]
                    if 0<=nx<m and 0<=ny<n:
                        findland(nx, ny)
                return True
            else:
                return False

        for i in range(m):
            for j in range(n):
                if findland(i, j):
                    res += 1
        return res