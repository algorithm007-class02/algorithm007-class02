class Solution {
    int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        if (s.length() <= 1)
            return 1;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int index = i - 1;
            if (s.charAt(index) == '0') {
                if (s.charAt(index - 1) != '1' && s.charAt(index - 1) != '2') {
                    return 0;
                } else {
                    dp[i] = dp[i - 2];
                }
            }
            // 1~9
            else if (s.charAt(index - 1) == '1'
                    || (s.charAt(index - 1) == '2' && s.charAt(index) >= '1' && s.charAt(index) <= '6')) {
                // s[i] 和 s[i-1]可以组合
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }
}