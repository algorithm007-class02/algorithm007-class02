package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/4/19 17:04
 * @Description:
 */
public class LeeCode_647_0226 {
    // 子问题   回文长度<=3,c[i] == c[j];长度大于3，c[i] == c[j],且c[i+1]~c[j-1]也是回文
    // dp数组   dp[i][j]表示c[i]~c[j]是否为回文
    // dp方程

    public int countSubstrings(String s) {
        char[] c = s.toCharArray();
        int len = s.length();

        boolean[][] dp = new boolean[len][len];
        int ans = 0;
        for(int l = 1; l <= len; l ++) {
            for(int i = 0; i + l - 1 < len; i ++) {
                int j = i + l - 1;
                if(c[i] == c[j] && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans ++;
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return ans;
    }
}
