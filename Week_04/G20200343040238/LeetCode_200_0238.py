class Solution:
    def numIslands(self, grid) -> int:
        len_g = len(grid)
        if len_g == 0:
            return 0
        len_r = len(grid[0])
        res = 0
        for i in range(len_g):
            for j in range(len_r):
                if grid[i][j] == "1":
                    res += 1
                    self.dfsClearLands(grid, i, j)
        return res

    def dfsClearLands(self, grid, i, j):
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] != "1":
            return
        grid[i][j] = "0"
        self.dfsClearLands(grid, i, j - 1)
        self.dfsClearLands(grid, i, j + 1)
        self.dfsClearLands(grid, i - 1, j)
        self.dfsClearLands(grid, i + 1, j)