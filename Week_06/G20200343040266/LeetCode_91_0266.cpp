class Solution {
public:
    int numDecodings(string s) {
        int len=s.length();
        if (s[0]=='0') return 0;
        if (len==1) return 1;
        vector<int> dp(len,0);
        dp[0]=1;
        if (s.substr(0,2)<="26") {
            dp[1] = (s[1]=='0'?1:2);
        } else {
            dp[1] = (s[1]=='0'?0:1);
        }

        for (int i=2;i<len;++i) {
            if (s.substr(i-1,2)>="1"&&s.substr(i-1,2)<="26") {
                if (s[i]=='0') {
                    dp[i]=dp[i-2];
                } else {
                    dp[i]=dp[i-1]+dp[i-2];
                }
            } else {
                if (s[i]=='0') return 0;
                else {
                    dp[i]=dp[i-1];
                }
            }
        }

        return dp[len-1];
    }
};