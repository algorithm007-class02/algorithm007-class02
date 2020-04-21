class Solution {
public:
    int countSubstrings(string s) {
        int l = s.length(), res = 0;
        vector<vector<int>> dp(l, vector<int> (l, 0));
        for(int i = 0; i < l; ++i){
            for(int j = i; j >= 0; --j){
                if(s[i] == s[j] && (i - j < 2 || dp[i - 1][j + 1])){
                    dp[i][j] = 1;
                    ++res;
                }
            }
        }

        return res;
    }
};
