package com.yequan.leetcode.recursion.climbstairs;

/**
 * @author : Administrator
 * @date : 2020/5/2
 */
public class RecodeClimbStairs {

    /**
     * 递归+去重
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        int[] cache = new int[n + 1];
        return helper(cache, n);
    }

    private int helper(int[] cache, int n) {
        if (n <= 2) {
            return n;
        }
        if (cache[n] > 0) {
            return cache[n];
        }
        cache[n] = helper(cache, n - 1) + helper(cache, n - 2);
        return cache[n];
    }

}
