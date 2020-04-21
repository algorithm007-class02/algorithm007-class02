class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        if (text1.empty() || text2.empty()) {
            return 0;
        }

        int text1Size = text1.size();
        int text2Size = text2.size();

        vector<vector<int>> dp(text1Size + 1, vector<int>(text2Size + 1));
        for (int i = 1; i <= text1Size; ++i) {
            for (int j = 1; j <= text2Size; ++j) {
                if (text1[i-1] == text2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[text1Size][text2Size];
    }
};