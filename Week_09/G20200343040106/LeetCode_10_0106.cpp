class Solution {
public:
    bool isMatch(string s, string p) {
        int m = s.size();
        int n = p.size();
        int dp[m+1][n+1];
        dp[0][0] = true;
        for(int i=1;i<=n;i++) {
            if(p[i-1]=='*') dp[0][i] = dp[0][i-2];
            else dp[0][i] = false;
        }
        for(int i=1;i<=m;i++) {
            dp[i][0] = false;
        }

        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                dp[i][j] = false;
                if(s[i-1]==p[j-1]||p[j-1]=='.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(p[j-1]=='*') {
                    dp[i][j] = j-2>=0?dp[i][j-2]:false;
                    if(j-2>=0&&(p[j-2]==s[i-1]||p[j-2]=='.')) {
                        dp[i][j] |= (dp[i-1][j-1]||dp[i-1][j]);
                    } 
                }
            }
        }
        return dp[m][n];
    }
};