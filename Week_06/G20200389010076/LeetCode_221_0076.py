#
# @lc app=leetcode.cn id=221 lang=python3
#
# [221] 最大正方形
#

# @lc code=start
from typing import List
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix==[]:
            return 0
        m=len(matrix)
        n=len(matrix[0])
        memo=[[0]*(n+1) for _ in range(m+1)]
        mside=0
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1]=='0':
                    continue
                tmin=min(memo[i-1][j],memo[i][j-1],memo[i-1][j-1])
                memo[i][j]=tmin+1
                mside=max(memo[i][j],mside)
        return mside*mside
            
# @lc code=end

