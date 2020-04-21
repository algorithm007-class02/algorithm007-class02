package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/4/19 17:06
 * @Description:
 */
public class LeeCode_32_0226 {
    // 1. 暴力，栈
    // 2. DP
    //  a.子问题，c[i]为')'，开始统计，c[i-1]为'(',则加2；若c[i-1]为')',看c[i - 2 - d[i-1]]
    //  b.状态dp[i],为第i个')'的最大长度
    //  c.dp[i] = dp[i - 2] + 2或者dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2


    public int longestValidParentheses(String s) {
        char[] cArray = s.toCharArray();
        int[] dp = new int[cArray.length];
        int max = 0;
        for(int i = 1; i < cArray.length; i ++ ) {
            if(cArray[i] == ')') {
                if(cArray[i - 1] == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                }else if(i - dp[i - 1] - 1 >= 0 && cArray[i - dp[i - 1] - 1] == '('){
                    dp[i] = dp[i - 1] +  (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] + 2 : 2);
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
}
