#
# @lc app=leetcode.cn id=874 lang=python3
#
# [874] 模拟行走机器人
#

# @lc code=start
class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]
        x = y = direction = 0
        obstacleSet = set(map(tuple, obstacles))
        res = 0
        for n in commands:
            if n == -1:
                direction = (direction + 1) % 4
            elif n == -2:
                direction = (direction - 1) % 4
            else:
                for k in range(n):
                    if (x+dx[direction], y+dy[direction]) not in obstacleSet:
                        x += dx[direction]
                        y += dy[direction]
                        res = max(res, x*x + y*y)
        return res

# 初见思路1：
# 用数字表示方位，0为North，1为east，2为south，3为west，所以-1表示方位+1，-2表示方位-1、
# 参考题解中采用set判断障碍点  

# @lc code=end

