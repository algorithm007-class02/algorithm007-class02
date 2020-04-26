class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector <int> > dp;
        dp.resize(m);
        for (int i = 0; i < m; ++i) {
            dp[i].resize(n);
        }

        for (int i = 0; i < n; ++i) {
            dp[0][i] = 1;
        }
        
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
};

// dp[i][j] 储存的是到达 i,j 
// 状态转移方程就是dp[i][j] = dp[i-1][j] + dp[i][j-1]


class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<int> dp(n, 1);
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }
};

// dp[j] = dp[j] + dp[j-1];
// dp[j] 表示每一行看做1个整体，i行相加后， 到了下面1行时， 上面的行到本行这个位置是1种走法
// dp[j-1] 表示左边位置走到本位置有多少路径