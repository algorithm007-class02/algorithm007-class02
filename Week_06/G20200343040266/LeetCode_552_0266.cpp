class Solution {
public:
    int checkRecord(int n) {
        long long dp[n][2][3];
        dp[0][0][0]=1;//第一个为P
        dp[0][0][1]=1;//第一个为L
        dp[0][0][2]=0;
        dp[0][1][0]=1;//第一个为A
        dp[0][1][1]=0;//不存在这种情况
        dp[0][1][2]=0;
        
        int BASE = 1000000007;

        for (int i=1;i<n;++i) {
            dp[i][0][0]=((dp[i-1][0][0]+dp[i-1][0][1])%BASE+dp[i-1][0][2])%BASE;//没有A且最后有0个连续的L，则第i个元素为P
            dp[i][0][1]=dp[i-1][0][0];
            dp[i][0][2]=dp[i-1][0][1];
            dp[i][1][0]=(((((dp[i-1][0][0]+dp[i-1][0][1])%BASE+dp[i-1][0][2])%BASE+dp[i-1][1][0])%BASE+dp[i-1][1][1])%BASE+dp[i-1][1][2])%BASE;
            dp[i][1][1]=dp[i-1][1][0];
            dp[i][1][2]=dp[i-1][1][1];
        }

        return (((((dp[n-1][0][0]+dp[n-1][0][1])%BASE+dp[n-1][0][2])%BASE+dp[n-1][1][0])%BASE+dp[n-1][1][1])%BASE+dp[n-1][1][2])%BASE;
    }
};