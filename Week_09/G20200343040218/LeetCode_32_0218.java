class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i > 1 ? dp[i - 2] : 0) + 2;
                } else {
                    int preI = i - dp[i-1] - 1;
                    if (preI >= 0 && s.charAt(preI) == '(') {
                        dp[i] = (preI > 0 ? dp[preI-1] : 0) + dp[i-1] + 2;
                    }
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}