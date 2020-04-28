package com.wxs.algorithm1.week07;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-25
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_70_0316 {

    public int climbStairs(int n) {
        if (n == 1) return n;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];

        }
        return dp[n];
    }


    public int climbStairs3(int n) {
        if(n == 1)return n;

        int first = 1;
        int second  =2;

        for (int i = 3; i <=n; i++) {

            int third = first + second;

            first = second;
            second = third;
        }

        return second;
    }


    public int climbStairs1(int n) {

        if (n == 1) return 1;

        int[] visited = new int[n + 1];
        return helper(visited,0);


    }

    private int helper(int[] visited, int i) {
        if(i <= 2)return i;

        if(visited[i] != 0){
            return visited[i];
        }

        visited[i] = helper(visited,i - 1) + helper(visited,i-2);
        return visited[i];

    }

}
