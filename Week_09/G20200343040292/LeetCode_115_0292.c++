//动态规划法
class Solution {
public:
	int numDistinct(string s, string t) {
		uint size1 = t.size() + 1;
		uint size2 = s.size() + 1;
		vector<vector<uint>> dp;
		for (uint i = 0; i < size1; ++i) {
			vector<uint> temp(size2, 0);
			dp.push_back(temp);
		}
		
		for (uint i = 0; i < size2; i++)
			dp[0][i] = 1;
		for (uint i = 1; i < size1; i++) {
			for (uint j = i; j < size2; j++) {
				if (s[j - 1] == t[i - 1])
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
				else
					dp[i][j] = dp[i][j - 1];
			}
		}

		return dp[size1 - 1][size2 - 1];
	}
};