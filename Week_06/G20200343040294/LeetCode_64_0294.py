class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
                
        #此数组用于记忆化搜索
        dp = [[0]*len(grid[0]) for i in range(len(grid))]

        for i in range(len(grid)):

            for j in range(len(grid[0])):

                #在起点的时候
                if (i == 0 and j == 0):
                    dp[i][j] = grid[0][0]

                #在左边缘的时候
                elif (j == 0 and i != 0): 
                    dp[i][j] = dp[i - 1][j]  + grid[i][j]

                #在上边缘的时候
                elif (i == 0 and j != 0):
                    dp[i][j] = dp[i][j-1] + grid[i][j]

                # 普遍情况下
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
                    
        return dp[len(grid)-1][len(grid[0])-1]
        

if __name__ == "__main__":
    grid = [[1,3,1],[2,3,4],[3,4,5]]
    sol = Solution()
    sol.minPathSum(grid)

