//下面这个答案是爆栈的解答。

class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        int n= prices.size();
        if(n==0||k==0) return 0;
        /*
        *   dp[i][j][k] 表示
        *   决策第i天
        *   目前已经交易的次数j
        *   目前手里有没有股票  0：有 1：没有股票
        */
        int dp[n][k+1][2];
        for(int j=0;j<=k;j++){
            dp[0][j][0] = INT_MIN;
            dp[0][j][1] = INT_MIN;
        }
        for(int i=0;i<n;i++){
            dp[i][0][0] = i==0?-prices[i]:max(dp[i-1][0][0],-prices[i]);
            dp[i][0][1] = INT_MIN;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=k;j++){
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
        int ans = 0;
        for(int i=0;i<=k;i++){
            ans = max(ans,dp[n-1][i][1]);
        }
        return ans;
    }
};