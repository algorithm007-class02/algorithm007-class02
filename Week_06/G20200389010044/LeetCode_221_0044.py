class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        '''
        正方形边长增加1说明，增加一列1, 1行1, 以及一个1
        从对角线看，就是dp[i+1]dp[j+1] = 1, dp[i+1]dp[j] = 1, dp[i][j+1] = 1
        动态规划方程: dp[i][j] = min(min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1
        '''
        if not matrix: return 0
        dp = [ [0 for _ in range(len(matrix[0]) + 1)] for _ in range(len(matrix) + 1) ]
        max_ = 0
        for i in range(1, len(matrix)+1):
            for j in range(1, len(matrix[0])+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1
                    max_ = max(max_, dp[i][j])
        return max_ * max_