package week03.g20200343040172;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 实战题目
 * LeetCode-70 Climbing stairs
 */
public class LeetCode_70_0172 {

    public static int[] memo = new int[100];

    public static void main(String[] args) {
        System.out.println(climbStairs_2(45));
    }

    /**
     * 方法一：暴力递归，没有存储相应的值，运行时会超时
     *
     * @param n
     * @return
     */
    public static int climbStairs_1(int n) {
        //Fn=Fn-1+Fn-2
        if (n <= 2) {
            return n;
        }
        int fn_1 = climbStairs_1(n - 1);
        int fn_2 = climbStairs_1(n - 2);
        int fn = fn_1 + fn_2;
        return fn;
    }


    /**
     * 方法二：递归加速，使用数组保存递归过程中的中间变量
     * 爬n阶楼梯的的走法=爬n-1阶楼梯的走法+爬n-2阶楼梯的走法
     *
     * @param n
     * @return
     */
    public static int climbStairs_2(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(n, memo);
    }


    public static int climb_Stairs(int n, int[] memo) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = climb_Stairs(n - 1, memo) + climb_Stairs(n - 2, memo);
        return memo[n];
    }
}
