package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/4/19 17:00
 * @Description:
 */
public class LeeCode_91_0226 {
    public int numDecodings(String s) {
        //1.子问题
        //2.定义状态数组
        //3.DP转移方程

        if(s == null || s.length() == 0) return 0;
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[length] = 1;
        if(s.charAt(length - 1) == '0') {
            dp[length - 1] = 0;
        }else{
            dp[length - 1] = 1;
        }
        for(int i = length - 2; i >= 0; i --) {
            if(s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            }else{
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}
