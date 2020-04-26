/*647. 回文子串*/

class Solution {
public:
    int countSubstrings(string s) {
        
        int size = s.size();
        int result = 0;
        vector<vector<bool>> dp(size, vector<bool>(size));

        for(int i = size - 1; i >= 0; i--)
        {
            for(int j = i; j < size; j++)
            {
                if((s[i] == s[j]) && (j - i <= 2 || dp[i+1][j-1])) dp[i][j] = true;
                if(dp[i][j]) result++;
            }
        }

        return result;
    }
};