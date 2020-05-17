// 1143. 最长公共子序列
// https://leetcode-cn.com/problems/longest-common-subsequence/
// 题目：LCS
// 解法：DP
// 时间：O(N^2)
// 空间：O(N^2)
// 关键：子序列与子串的区别
class Solution {
public:
	int longestCommonSubsequence(string text1, string text2) {
		int s1 = text1.size();
		int s2 = text2.size();
		vector<vector<int>> dp(s1 + 1, vector<int>(s2 + 1, 0));
		for (int i = 1; i < s1 + 1; i++) {
			for (int j = 1; j < s2 + 1; j++) {
				if (text1[i-1] == text2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[s1][s2];
	}
};