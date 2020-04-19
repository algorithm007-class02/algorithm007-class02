class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        states = grid
        for i in range(1,n):
            states[0][i] += states[0][i-1]
        for i in range(1,m):
            states[i][0] += states[i-1][0]
        for i in range(1,m):
            for j in range(1,n):
                states[i][j] += min(states[i-1][j],states[i][j-1])
        return states[m-1][n-1]
