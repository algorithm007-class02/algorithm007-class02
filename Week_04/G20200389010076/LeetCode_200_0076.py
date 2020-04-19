class Solution:
    directions=[(-1,0),(0,-1),(1,0),(0,1)]
    def numIslands(self, grid: List[List[str]]) -> int:
        m=len(grid)
        if m==0:
            return 0
        n=len(grid[0])
        visited=[[False for _ in range(n)] for _ in range(m)]
        island=0
        for i in range(m):
            for j in range(n):
                if not visited[i][j] and grid[i][j]=='1':
                    island+=1
                    queue=deque()
                    queue.append((i,j))
                    while queue:
                        x,y=queue.popleft()
                        for direction in self.directions:
                            new_x=x+direction[0]
                            new_y=y+direction[1]
                            if 0<=new_x<m and 0<=new_y<n and not visited[new_x][new_y] and grid[new_x][new_y]=='1':
                                queue.append((new_x,new_y))
                                visited[new_x][new_y]=True
        return island