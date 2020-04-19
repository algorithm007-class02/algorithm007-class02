class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
            
        x_len = len(grid)
        y_len = len(grid[0])
        count = 0

        def near_points(location):
            x,y = location
            location_left = (x,y-1) if y>0 else []
            location_right = (x,y+1) if y<y_len-1 else []
            location_up = (x-1,y) if x>0 else []
            location_down = (x+1,y) if x<x_len-1 else []
            return (location_left,location_right,location_up,location_down)

        def dfs(location,net):
            if not location:
                return
            x,y = location
            if net[x][y] == '0':
                return
            else:
                net[x][y] = '0'
            for i in near_points(location):
                dfs(i,net)

        for i in range(x_len):
            for j in range(y_len):
                if grid[i][j] == '1':
                    dfs((i,j),grid)
                    count +=1
        return count
