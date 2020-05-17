package com.wxs.algorithm1.week09;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/15
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_1143_0316 {

    public static void main(String[] args) {
        LeetCode_1143_0316 longestCommonSubsequence1143 = new LeetCode_1143_0316();
        int i = longestCommonSubsequence1143.longestCommonSubsequence("abcde", "ace");
        System.out.println(i);
    }
    public int longestCommonSubsequence(String text1, String text2) {

        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }

        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }


}
