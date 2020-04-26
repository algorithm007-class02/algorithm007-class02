class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        if(m==0) return 0;
        int n = matrix[0].size();
        if(n==0) return 0;
        vector<vector<int>> dp = vector(m+1,vector<int>(n+1,0));
        int ans = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = matrix[i-1][j-1]=='0'?0:min(dp[i-1][j-1],min(dp[i-1][j],dp[i][j-1]))+1;
                ans = max(ans,dp[i][j]);
            }
        }
        return ans*ans;
    }
};