class Solution {
public:
    int longestValidParentheses(string s) {
        int n=s.size();
        if (n<=1) return 0;
        int ans=0;
        int dp[n];

        dp[0]=0;
        for (int i=1;i<n;++i) {
            if (s[i]==')') {
                if (s[i-1]=='(') dp[i]=(i-2>=0?dp[i-2]:0)+2;
                else {
                    if (i-dp[i-1]-1>=0&&s[i-dp[i-1]-1]=='(') {
                        dp[i]=2+dp[i-1]+(i-1-dp[i-1]-1>=0?dp[i-1-dp[i-1]-1]:0);
                    }else dp[i]=0;
                }
                ans=max(ans,dp[i]);
            } else dp[i]=0;
        }
        return ans;
    }
};