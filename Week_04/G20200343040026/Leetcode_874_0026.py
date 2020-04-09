# 方向向量逐步探测法
class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        if commands == []:
            return 0
        # 上右下左方向向量
        dirx = [0, 1, 0, -1]
        diry = [1, 0, -1, 0]
        e = 0
        x = 0
        y = 0
        maxd = 0
        obstacles = set(map(tuple, obstacles))
        for command in commands:
            if command <= 0:
                if command == -1:
                    e = (e+1) % 4
                if command == -2:
                    e = (e+3) % 4
            else:
                i = 0
                while i < command:
                    x += dirx[e]
                    y += diry[e]
                    if (x,y) in obstacles:
                        x -= dirx[e]
                        y -= diry[e]
                        break
                    if x*x+y*y > maxd:
                        maxd = x*x + y*y
                    i += 1
        return maxd