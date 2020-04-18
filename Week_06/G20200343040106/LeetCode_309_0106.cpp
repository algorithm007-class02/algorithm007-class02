class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        if(n<=1) return 0;
        //dp里面存的值为第i天，手里（0：有股票，1：没股票）的时候的利润
        // dp[i][0] 手里有股票  dp[i][1] 手里没股票
        int dp[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;  // 不可能 也就是赚了0元
        dp[1][0] = max(dp[0][0],-prices[1]);
        dp[1][1] = max(dp[0][1],prices[1]-prices[0]);
        for(int i=2;i<n;i++){
            dp[i][0] = max(dp[i-1][0],dp[i-2][1]-prices[i]);
            dp[i][1] = max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }

        return dp[n-1][1];  // 返回第i天，手里没有股票所获得的最大利润
    }
};