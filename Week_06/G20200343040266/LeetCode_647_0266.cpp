class Solution {
public:
    int countSubstrings(string s) {
        if (s.length()==0) return 0;
        if (s.length()==1) return 1;
        int n=s.length();
        int sum=n;
        vector<vector<bool>> dp(n,vector<bool>(n,false));
        for (int i=0;i<n;++i) dp[i][i]=true;

        for (int r=2;r<=n;++r) {
            for (int i=0;i<n-r+1;++i) {
                int j=i+r-1;
                if (r==2) {
                    if (s[i]==s[j]) {dp[i][j]=true;sum++;}
                    else dp[i][j]=false;
                } else {
                    dp[i][j]=dp[i+1][j-1]&&s[i]==s[j];
                    if (dp[i][j]) sum++;
                }
            }
        }

        return sum;
    }
};
