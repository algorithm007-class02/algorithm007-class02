/*
动态规划
时间复杂度：O(M^2*N^2)
空间复杂度：O(M*N)
*/
class Solution {
public:
	int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
		int rows = matrix.size(), cols = matrix[0].size();
		int max = 1 << 31;
		for (int i1 = 1; i1 <= rows; i1++) {
			for (int j1 = 1; j1 <= cols; j1++) {
				int dp[rows + 1][cols + 1];
                memset(dp, 0, sizeof(dp));
				dp[i1][j1] = matrix[i1 - 1][j1 - 1];
				for (int i2 = i1; i2 <= rows; i2++) {
					for (int j2 = j1; j2 <= cols; j2++) {
						dp[i2][j2] = dp[i2 - 1][j2] + dp[i2][j2 - 1] - dp[i2 - 1][j2 - 1] + matrix[i2-1][j2-1];
						if (dp[i2][j2] > max && dp[i2][j2] <= k) {
							max = dp[i2][j2];
						}
					}
				}
			}
		}
		return max;
	}
};