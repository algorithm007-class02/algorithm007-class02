class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int dp[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            dp[i] = amount+1;
            for(int j=0;j<coins.size();j++){
                dp[i] = i-coins[j]>=0?min(dp[i],dp[i-coins[j]]+1):dp[i];
            }
        }

        return dp[amount]==amount+1?-1:dp[amount];
    }
};