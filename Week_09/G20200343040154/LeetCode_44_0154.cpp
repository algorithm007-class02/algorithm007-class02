// 44.通配符匹配
// https://leetcode-cn.com/problems/wildcard-matching/

class Solution {
public:
	bool isMatch(string s, string p) {
		int n = s.size(), m = p.size();
		vector< vector<bool> > dp(n+1, vector<bool>(m+1, false)); dp[0][0] = true;
		for (int i = 1; i <= m; ++ i){
			if(p[i - 1] == '*' && dp[0][i - 1]) dp[0][i] = dp[0][i - 1];
		}

		for (int i = 1; i <= n; ++ i){
			for (int j = 1; j <= m; ++ j){
				if (s[i - 1] == p[j - 1] || p[j - 1] == '?'){
					dp[i][j] = dp[i - 1][j - 1];
				}else if (p[j - 1] == '*'){
					bool zero, mul;
					zero = (j < m && s[i - 1] == p[j] && dp[i - 1][j - 1]) || dp[i][j - 1];
					mul = dp[i -1][j];
					dp[i][j] = zero || mul;
				}
			}
		}

		return dp[n][m];
	}
};