import itertools


class Solution:
    def minPathSum(self, grid):
        m, n = len(grid), len(grid[0])
        # 使用累加值序列得到取出第一行结果
        dp = [path for path in itertools.accumulate(grid[0])]
        # 通过遍历,得到每一步最小值,最后返回终点所在的值
        for i in range(1, m):
            dp[0] += grid[i][0]
            for j in range(1, n):
                print(dp)
                # 这里获得之前路径最小的和,dp[j-1]是grid(i,j-1)最小路径,dp[j]是grid[i-1,j]最小路径
                dp[j] = min(dp[j - 1], dp[j]) + grid[i][j]
                print(dp[j])
        return dp[-1]
