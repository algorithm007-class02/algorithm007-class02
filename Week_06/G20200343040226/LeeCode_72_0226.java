package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/4/19 17:08
 * @Description:
 */
public class LeeCode_72_0226 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        //其中一个为0，直接返回

        if(m * n == 0) {
            return m + n;
        }

        int[][] D = new int[n + 1][m + 1];

        //初始化边界条件
        for (int i = 0; i < m + 1; i ++) {
            D[0][i] = i;
        }

        for (int j = 0; j < n + 1; j ++) {
            D[j][0] = j;
        }

        //计算DP值
        for (int i = 1; i < n + 1; i ++) {
            for (int j = 1; j < m + 1; j ++) {
                int left = D[i - 1][j] + 1;
                int leftDown = D[i - 1][j - 1];
                int down = D[i][j - 1] + 1;
                if(word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftDown += 1;
                }
                D[i][j] = Math.min(left,Math.min(leftDown,down));
            }
        }

        return D[n][m];
    }
}
