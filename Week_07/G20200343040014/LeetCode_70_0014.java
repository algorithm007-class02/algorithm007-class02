class Solution {
    public int climbStairs(int n) {
        // if (n == 1) return 1;
        // if (n < 3) return 2;
        // return climbStairs (n-1) + climbStairs (n-2);
        if (n == 1) return 1;
        if (n < 3) return 2;
        if (n == 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 2;
        for (int i = 2; i < n; i++){
            dp[i] = dp[i -1] +dp[i -2];
        }
        return dp[n-1];
    }
}