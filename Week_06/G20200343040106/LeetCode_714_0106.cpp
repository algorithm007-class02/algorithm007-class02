class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        int n = prices.size();
        if(n<=1) return 0;
        int dp[n][2];

        dp[0][0] = -prices[0]-fee;
        dp[0][1] = 0;

        for(int i=1;i<n;i++){
            dp[i][0] = max(dp[i-1][0],dp[i-1][1]-prices[i]-fee);
            dp[i][1] = max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }

        return dp[n-1][1];
    }
};