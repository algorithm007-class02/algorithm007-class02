package com.wxs.algorithm1.week06;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-19
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_70_0316 {

    public int climbStairs(int n) {


        int[] arr = new int[n + 1];

        return climb(n, arr);
    }

    private int climb(int n, int[] arr) {


        if (n <= 2) {
            return n;
        }

        if (arr[n] == 0) {

            arr[n] = climb(n - 1, arr) + climb(n - 2, arr);

        }
        return arr[n];
    }


    // 动态规划
    public int climbStairs2(int n) {

        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;


        for (int i = 3; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];

        }

        return dp[n];
    }


}
