#
# @lc app=leetcode.cn id=64 lang=python3
#
# [64] 最小路径和

#

# @lc code=start
from typing import List
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m=len(grid)
        n=len(grid[0])
        memo=[[-1]*n+[float('inf')] for _ in range(m)]+[[float('inf')]*(n+1)]
        memo[m-1][n-1]=grid[m-1][n-1]
        def dp(i,j):
            if memo[i][j]!=-1:
                return memo[i][j]
            down=dp(i+1,j)
            right=dp(i,j+1)
            memo[i][j]=min(down,right)+grid[i][j]
            return memo[i][j]
        return dp(0,0)
# @lc code=end

print(Solution().minPathSum([[0,0],[0,0]]))