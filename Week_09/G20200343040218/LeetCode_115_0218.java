class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[0][i] = 1;
        }
        for (int row = 1; row < t.length() + 1; row++) {
            for (int col = 1; col < s.length() + 1; col++) {
                if (s.charAt(col - 1) == t.charAt(row - 1)) {
                    dp[row][col] = dp[row][col - 1] + dp[row - 1][col - 1];
                } else {
                    dp[row][col] = dp[row][col - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}