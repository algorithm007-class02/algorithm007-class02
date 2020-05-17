class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        row = len(grid)-1
        col = len(grid[0])-1
        def DFS(x,y):
            if x<0 or y<0 or x > row or y > col or grid[x][y] == '0':
                return
            grid[x][y] = '0'
            DFS(x-1,y)
            DFS(x+1,y)
            DFS(x,y-1)
            DFS(x,y+1)
        count = 0
        for i in range(row+1):
            for j in range(col+1):
                if grid[i][j] == '1':
                    count += 1
                    DFS(i,j)
        return count