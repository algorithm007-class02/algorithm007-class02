/*
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
//trac[i][2], 0表示未持有，1表示持有
//trac[i][0] = max(trac[i - 1][0], trac[i - 1][1] + prices[i]);
//trac[i][1] = max(trac[i - 1][1], trac[i - 2][0] - prices[i]);
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        int trac_i_0 = 0, trac_i_1 = INT_MIN;
        int trac_pre_0 = 0; // 代表 trac[i-2][0]
        for (int i = 0; i < n; ++i) {
            int temp = trac_i_0;
            trac_i_0 = max(trac_i_0, trac_i_1 + prices[i]);
            trac_i_1 = max(trac_i_1, trac_pre_0 - prices[i]);
            trac_pre_0 = temp;
        }
        return trac_i_0;
    }
};