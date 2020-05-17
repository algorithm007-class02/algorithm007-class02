package com.wxs.algorithm1.week09;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020/5/14
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_72_0316 {


    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        LeetCode_72_0316 minDistance72 = new LeetCode_72_0316();
        int i = minDistance72.minDistance(word1, word2);
        System.out.println(i);

    }

    public int minDistance(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];



        for (int j = 1; j <= n2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n1; i++) {
            dp[i][0] = i;

        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j])+1;

                }

            }

        }

        return dp[n1][n2];
    }

    public int minDistance1(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // dp[0][0...n2]的初始值
        for (int j = 1; j <= n2; j++)
            dp[0][j] = dp[0][j - 1] + 1;
        // dp[0...n1][0] 的初始值
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;
        // 通过公式推出 dp[n1][n2]
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // 如果 word1[i] 与 word2[j] 相等。第 i 个字符对应下标是 i-1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }


}
