// 递归
class Solution {
public:
    int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n <= 2) return n;
        vector<int> vec(n + 1, 0);
        vec[1] = 1;
        vec[2] = 2;
        return helper(vec, n);
    }

    int helper(vector<int>& vec, int n){
        vec[n] = (vec[n - 1] != 0 ? vec[n - 1] : helper(vec, n - 1)) + (vec[n - 2] != 0 ? vec[n - 2] : helper(vec, n - 2));
        return vec[n];
    }
};

//dp
class Solution {
public:
    int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n <= 2) return n;
        vector<int> dp(n + 1, 0);
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; ++i){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
};