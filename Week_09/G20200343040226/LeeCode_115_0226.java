package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/5/17 16:44
 * @Description:    115. 不同的子序列
 */
public class LeeCode_115_0226 {

    /**
     * dp[i][j],T的前i个字符，由S的前j个字符组成的最多个数
     *
     * T[i] == S[j],dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1]
     * T[i] != S[j],dp[i][j] = dp[i][j - 1]
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        char[] arrS = s.toCharArray ();
        char[] arrT = t.toCharArray ();

        int m = arrS.length;
        int n = arrT.length;

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= m; i ++) {
            dp[0][i] = 1;
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                if(arrS[j - 1] == arrT[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }else{
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[n][m];

    }
}
