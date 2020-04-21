/*
这里买入就算一次交易。
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
              max(   选择 rest  ,           选择 sell      )

解释：今天我没有持有股票，有两种可能：
要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。

dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
              max(   选择 rest  ,           选择 buy         )

解释：今天我持有着股票，有两种可能：
要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
*/
/*
base case:
dp[0][t][0] 0天t次交易，手上不持有：可能 0
dp[0][t][1] 0天t次交易，手上持有：不可能
dp[i][0][0] i天0次交易，手上不持有：可能 0
dp[i][0][1] i天0次交易，手上持有：不可能
*/
class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        int n = prices.size();
        if (k > n / 2) {//可以进行任意次交易,提前处理掉，省的dp数组过大
            int res = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;
        }
        int trac[n + 1][k + 1][2];//+1以便处理day 0及0次交易的初始状态
        for (int j = 0; j <= k; ++j) {
            trac[0][j][0] = 0;//0天t次交易，手上不持有，可能，0
            trac[0][j][1] = INT_MIN;//0天t次交易，手上持有，不可能
        }
        for (int i = 0; i <= n; ++i) {
            trac[i][0][0] = 0;//i天没有交易，手上不持有，可能，0
            trac[i][0][1] = INT_MIN;//i天没有交易，手上持有，不可能
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                trac[i][j][0] = max(trac[i - 1][j][0], trac[i - 1][j][1] + prices[i - 1]);
                trac[i][j][1] = max(trac[i - 1][j][1], trac[i - 1][j - 1][0] - prices[i - 1]);
            }
        }
        return trac[n][k][0];
    }
};