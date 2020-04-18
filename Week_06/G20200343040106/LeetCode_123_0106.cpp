class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int ans = 0;
        int n= prices.size();
        if(n==0) return 0;
        /*
        *   dp[i][j][k] 表示
        *   决策第i天
        *   目前已经交易的次数j
        *   目前手里有没有股票  0：有 1：没有股票
        */
        int dp[n][3][2];
        for(int j=0;j<=2;j++){
            dp[0][j][0] = INT_MIN;
            dp[0][j][1] = INT_MIN;
        }
        for(int i=0;i<n;i++){
            dp[i][0][0] = i==0?-prices[i]:max(dp[i-1][0][0],-prices[i]);
            dp[i][0][1] = INT_MIN;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=2;j++){
                dp[i][j][0] = dp[i-1][j][0];
                if(dp[i-1][j][1]!=INT_MIN){
                    dp[i][j][0] = max(dp[i][j][0],dp[i-1][j][1]-prices[i]);
                }
                //dp[i][j][0] = max(dp[i-1][j][0],dp[i-1][j][1]-prices[i]);
                //dp[i][j][1] = max(dp[i-1][j][1],dp[i-1][j-1][0]+prices[i]);
                dp[i][j][1] = dp[i-1][j][1];
                if(dp[i-1][j-1][0]!=INT_MIN){
                    dp[i][j][1] = max(dp[i][j][1],dp[i-1][j-1][0]+prices[i]);
                }
            }
        }
        return max(0,max(dp[n-1][1][1],dp[n-1][2][1]));
    }
};