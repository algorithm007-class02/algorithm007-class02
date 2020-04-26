package com.wxs.algorithm1.week06;

import java.util.Arrays;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-16
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_62_0316 {


    public static void main(String[] args) {


        LeetCode_62_0316 uniquePaths62 = new LeetCode_62_0316();

        int i = uniquePaths62.uniquePaths1(3, 7);
        System.out.println(i);
    }


    public int uniquePaths(int m, int n) {


        int[][] arr = new int[m][n];

        for (int i = 0; i < n; i++) {
           arr[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
           arr[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];

            }

        }

        return arr[m -1][n -1];

    }

    public int uniquePaths1(int m, int n) {

        int[] curr = new int[n]; // 只记录最后一列

        Arrays.fill(curr,1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                curr[j] += curr[j-1];
            }
        }
        return curr[n-1];
    }



}
