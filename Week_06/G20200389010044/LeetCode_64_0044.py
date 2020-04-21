class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        '''
        动态规划的状态数组可以从二维优化到一维
        我们开始遍历后，把最小路径和存储在一维数组对应的列中
        而我们是从左往右从上往下遍历
        所以如果是中间的元素，即需要考虑下移到达当前还是右移到达当前的情况
        只需要考虑dp[j-1]（右边元素）和dp[j]（上边元素）哪个小
        '''
        # dp = [ [0 for _ in range(len(grid[0]))] for _ in range(len(grid)) ]
        # dp[0][0] = grid[0][0]
        # for j in range(1, len(grid[0])):
        #     dp[0][j] = dp[0][j-1] + grid[0][j]
        # for i in range(1, len(grid)):
        #     dp[i][0] = dp[i-1][0] + grid[i][0]
        # for i in range(1, len(grid)):
        #     for j in range(1, len(grid[0])):
        #         dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
        # return dp[-1][-1]

        dp = [ 0 for _ in range(len(grid[0])) ]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if i == 0 and j == 0:
                    dp[j] = grid[i][j]
                elif i == 0 and j != 0:
                    dp[j] = dp[j-1] + grid[i][j]
                elif i != 0 and j == 0:
                    dp[j] = dp[j] + grid[i][j]
                else:
                    dp[j] = min(dp[j-1], dp[j]) + grid[i][j]
        return dp[-1]