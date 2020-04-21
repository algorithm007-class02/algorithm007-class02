class Solution {
public:
    int countSubstrings(string s) {
        int n = s.size();
        vector<vector<bool>> dp = vector(n,vector<bool>(n,true));

        int ans = n;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                dp[i][j] = s[i]==s[j]?dp[i+1][j-1]:false;
                ans += dp[i][j]?1:0;
            }
        }
        return ans;
    }
};