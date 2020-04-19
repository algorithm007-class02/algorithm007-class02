/*
动态规划
时间复杂度：O(N)
空间复杂度：O(N)
*/
class Solution {
public:
	int longestValidParentheses(string s) {
		int maxLen = 0;
		int len = s.size();
		vector<int> dp;
		dp.resize(s.size());
		for (int i = 1; i < s.size(); i++) {
			if (s[i] == ')') {
				if (s[i - 1] == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				}
				else if (i - dp[i - 1] > 0 && s[i - dp[i - 1] - 1] == '(') {
					dp[i] = dp[i - 1] + (i - dp[i - 1] - 1 > 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
				maxLen = max(maxLen, dp[i]);
			}
		}
		return maxLen;
	}
};