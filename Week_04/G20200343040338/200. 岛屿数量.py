"""
>>> s = Solution()
>>> grid = ['11110', '11010', '11000', '00000']
>>> s.numIslands(grid)
1
>>> s = Solution()
>>> grid = ['11000', '11000', '00100', '00011']
>>> s.numIslands(grid)
3
"""
from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = set()
        count = 0

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if (i, j) in visited:
                    continue

                if grid[i][j] == '1':
                    count += 1
                    self._mark_island(grid, visited, i, j)

        return count

    def _mark_island(self, grid, visited, i, j):
        if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[i]):
            return

        if grid[i][j] == '0':
            return

        if (i, j) in visited:
            return

        visited.add((i, j))

        self._mark_island(grid, visited, i - 1, j)
        self._mark_island(grid, visited, i, j - 1)
        self._mark_island(grid, visited, i + 1, j)
        self._mark_island(grid, visited, i, j + 1)
