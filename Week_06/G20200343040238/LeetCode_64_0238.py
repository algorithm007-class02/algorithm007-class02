class Solution:
    def minPathSum(self, grid: list) -> int:
        len_grid = len(grid)
        if not len_grid:
            return 0
        len_row = len(grid[0])
        for i in range(len_grid):
            for j in range(len_row):
                if i == j == 0:
                    continue
                elif i == 0:
                    grid[i][j] += grid[i][j - 1]
                elif j == 0:
                    grid[i][j] += grid[i - 1][j]
                else:
                    grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])
        return grid[len_grid - 1][len_row - 1]
