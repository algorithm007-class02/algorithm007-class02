class Solution {
    /**
     * 从后向前推
     * @param s
     * @return
     */
    public int numDecodings1(String s) {
        if(null == s || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if(s.charAt(len - 1) == '0'){
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        for(int i = len - 2;i >= 0;i--){
            if(s.charAt(i) == '0'){
                dp[i] = 0;
                continue;
            }
            if((s.charAt(i)-'0') * 10 + (s.charAt(i + 1) - '0') <= 26){
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    /**
     * 从前向后
     * @param s
     * @return
     */
    public  int numDecodings2(String s) {
        if(null == s || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        if(s.charAt(0) == '0'){
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }
        for(int i = 1;i <= len - 1;i++){
            if(s.charAt(i) == '0'){
                dp[i + 1] = 0;
                continue;
            }
            if((s.charAt(i - 1)-'0') * 10 + (s.charAt(i) - '0') <= 26){
                dp[i + 1] = dp[i - 1] + dp[i];
            } else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[len];
    }
}