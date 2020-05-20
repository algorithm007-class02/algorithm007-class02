package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/5/17 16:03
 * @Description:
 */
public class LeeCode_44_0226 {

    /**
     * 状态dp[i][j]:s的前i个字符和p的前j个字符，是否匹配
     * 状态转移方程:
     *  1. dp[i][j] = dp[i - 1][j - 1],若s[i] = p[j] || p[j] = '?'
     *  2. dp[i][j] = dp[i - 1][j] || dp[i][j - 1],若p[j] = '*'
     * 初始化：
     *  1. dp[i][0] = false,p为空串
     *  2. dp[0][j] = dp[0][j - 1]，s为空串，若p为'*' 才匹配
     *  3. dp[0][0] = true;
     *
     *
     * @param s
     * @param p
     * @return
     */


    public boolean isMatch(String s, String p) {
        char[] arrS = s.toCharArray ();
        char[] arrP = p.toCharArray ();

        int m = arrS.length;
        int n = arrP.length;

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for(int i = 1; i <= n; i ++) {
            dp[0][i] = dp[0][i - 1] && arrP[i - 1] == '*';
        }

        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(arrS[i - 1] == arrP[j - 1] || arrP[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(arrP[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[m][n];

    }
}
