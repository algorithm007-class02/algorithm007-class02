/*
 * @lc app=leetcode.cn id=115 lang=cpp
 *
 * [115] 不同的子序列
 */

// @lc code=start
/**
 * dp[i][j] 代表 T 前 i 字符串可以由 S j 字符串组成最多个数.
 * 当 S[j] == T[i] , dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
 * 当 S[j] != T[i] , dp[i][j] = dp[i][j-1]
 * */
class Solution {
public:
    int numDistinct(string s, string t) {
        int ns = s.size();
        int nt = t.size();

        vector<vector<long>> dp(ns + 1, vector<long>(nt + 1, 0));
        dp[0][0] = 1;
        for (int i = 0; i < ns; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= ns; i++) {
            for (int j = 1; j <= nt; j++) {
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[ns][nt];
    }
};
// @lc code=end
