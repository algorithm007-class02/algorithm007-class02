class Solution {
public:
    int longestPalindromeSubseq(string s) {
        int n = s.size();
        if(n<=1) return n;
        vector<vector<int>> dp = vector(n,vector<int>(n,0));
        for(int i=0;i<n;i++){
            dp[i][i] = 1;
        }
        int ans = 1;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                dp[i][j] = s[i]==s[j]?dp[i+1][j-1]+2:max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
};