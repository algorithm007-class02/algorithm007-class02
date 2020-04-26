class Solution {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int dp[] = new int [s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){ //上一个括号可以和当前形成组合
                    dp[i] = ( i >= 2 ? dp[i - 2] : 0) +2;
                }else if(i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '('){ //排除掉已经计算过的括号后，再判断前一个括号是否可以和当前形成组合，dp[i - 1]代表上一步中已经得知的有效括号长度，减去这个长度后就可方便的得到尚未匹配的那个括号。
                    dp[i] = dp[i - 1] + ((i -2 - dp[i - 1]) >= 0 ? dp[i -2 - dp[i - 1]]:0)  + 2 ;
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        return maxLength;
    }
}