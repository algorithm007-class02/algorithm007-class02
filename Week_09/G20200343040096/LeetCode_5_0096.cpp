class Solution {
public:
    string longestPalindrome(string s) {
        int len = s.length(), lp = 0, start = 0;
        vector<vector<bool>> dp(len, vector<bool>(len, 0));
        for(int i = 0; i < len; ++i){
            dp[i][i] = true;
            lp = 1;
        }
        for(int l = 2; l <= len; ++l){
            for(int i = 0; i <= len - l; ++i){
                int j = i + l - 1;
                if(l == 2){
                    if(s[i] == s[j]) {
                        dp[i][j] = true;
                        start = i;
                        lp = l;
                    }
                }else{
                    if(s[i] == s[j] && dp[i + 1][j - 1]){
                        dp[i][j] = true;
                        start = i;
                        lp = l;
                    }
                }
            }
        }
        return s.substr(start, lp);
    }
};
