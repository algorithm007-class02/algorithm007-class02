class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        vector<vector<int>> dp;
        dp.resize(obstacleGrid.size());
        for (int i = 0; i < obstacleGrid.size(); ++i) {
            dp[i].resize(obstacleGrid[0].size());
        }

        for (int i = 0; i < obstacleGrid[0].size(); ++i) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            }          
        }

        for (int i = 0; i < dp[0].size(); ++i) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < dp.size(); ++i) {
            for (int j = 1; j < dp[i].size(); ++j) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[obstacleGrid.size()-1][obstacleGrid[0].size()-1];
    }
};