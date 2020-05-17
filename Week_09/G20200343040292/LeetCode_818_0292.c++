//动态规划法
class Solution {
public:
	int racecar(int target) {
		vector<int> dp(target + 3, 0x7fffffff);
		dp[0] = 0; dp[1] = 1; dp[2] = 4;

		for (int i = 3; i <= target;i++) {
			int k = 32 - numberOfLeadingZeros(i);
			if (i == (1 << k) - 1) {
				dp[i] = k;
				continue;
			}
			for (int j = 0; j < k - 1;j++) {
				dp[i] = min(dp[i], dp[i - (1 << (k - 1)) + (1 << j)] + k - 1 + j + 2);
			}
			if ((1 << k) - 1 - i < i) {
				dp[i] = min(dp[i], dp[(1 << k) - 1 - i] + k + 1);
			}
		}
		return dp[target];
	}
	int numberOfLeadingZeros(int i) {
		if (i == 0)
			return 32;
		int n = 1;
		if (i >> 16 == 0) { n += 16; i <<= 16; }
		if (i >> 24 == 0) { n += 8; i <<= 8; }
		if (i >> 28 == 0) { n += 4; i <<= 4; }
		if (i >> 30 == 0) { n += 2; i <<= 2; }
		int temp = (unsigned int)i >> 31;
		n -= temp;
		return n;
	}
};