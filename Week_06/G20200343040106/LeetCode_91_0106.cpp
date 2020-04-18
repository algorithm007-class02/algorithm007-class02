class Solution {
public:
    int numDecodings(string s) {
        int n = s.size();
        if(n==0) return 0;
        int dp[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            // 当s[i-2,i-1]是一个有效的字母
            dp[i] = i-2<0||s[i-2]=='0'||s[i-2]>'2'||(s[i-2]=='2'&&s[i-1]>'6')?0:dp[i-2];
            // 当s[i-1]!='0'
            dp[i] += s[i-1]=='0'?0:dp[i-1];
        }
        return dp[n];
    }
};
