#
# @lc app=leetcode.cn id=200 lang=python3
#
# [200] 岛屿数量
#

# @lc code=start
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == '1':  # 发现陆地
                    count += 1  # 结果加1
                    grid[row][col] = '0'  # 将其转为 ‘0’ 代表已经访问过
                    # 对发现的陆地进行扩张即执行 BFS，将与其相邻的陆地都标记为已访问
                    # 下面还是经典的 BFS 模板
                    land_positions = collections.deque()
                    land_positions.append([row, col])
                    while len(land_positions) > 0:
                        x, y = land_positions.popleft()
                        for new_x, new_y in [[x, y + 1], [x, y - 1], [x + 1, y], [x - 1, y]]:  # 进行四个方向的扩张
                            # 判断有效性
                            if 0 <= new_x < len(grid) and 0 <= new_y < len(grid[0]) and grid[new_x][new_y] == '1':
                                grid[new_x][new_y] = '0'  # 因为可由 BFS 访问到，代表同属一块岛，将其置 ‘0’ 代表已访问过
                                land_positions.append([new_x, new_y])
        return count
# @lc code=end

