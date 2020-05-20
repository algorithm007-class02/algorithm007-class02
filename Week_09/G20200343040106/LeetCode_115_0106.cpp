class Solution {
public:
    int numDistinct(string s, string t) {
        int m = s.size();
        int n = t.size();
        if(m<n){
            return 0;
        }
        vector<vector<long>> dp = vector(m+1,vector<long>(n+1,0));
        for(int i=0;i<=m;i++) {
            dp[i][0] = 1;
        }
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=min(i,n);j++) {
                dp[i][j] = dp[i-1][j];
                dp[i][j] += s[i-1]==t[j-1]?dp[i-1][j-1]:0;
                /*
                if(s[i-1]==t[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }*/
            }
        }
        return dp[m][n];
    }
};