class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        dx = [0,1,0,-1]
        dy = [1,0,-1,0]
        x,y,di = 0,0,0
        ans = 0
        obst_set = set(map(tuple,obstacles))
        for c in commands:
            if c == -2:
                di = (di-1)%4
            elif c == -1:
                di = (di+1)%4
            else:
                for i in range(c):
                    if not (x+dx[di],y+dy[di]) in obst_set:
                        x = x+dx[di]
                        y = y+dy[di]
                        ans = max(ans,x**2+y**2)
        return ans
