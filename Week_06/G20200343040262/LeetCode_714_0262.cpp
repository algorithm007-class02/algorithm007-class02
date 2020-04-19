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
//trac[i][0] = max(trac[i - 1][0], trac[i - 1][1] + prices[i]);
//trac[i][1] = max(trac[i - 1][1], trac[i - 1][0] - prices[i] - fee);
class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        int n = prices.size();
        int trac[n + 1][2];
        trac[0][0] = 0;//day 0, not hold
        trac[0][1] = INT_MIN;//day 0, holded
        for (int i = 1; i <= n; ++i) {
            trac[i][0] = max(trac[i - 1][0], trac[i - 1][1] + prices[i - 1]);
            trac[i][1] = max(trac[i - 1][1], trac[i - 1][0] - prices[i - 1] - fee);
        }
        return trac[n][0];
    }
};