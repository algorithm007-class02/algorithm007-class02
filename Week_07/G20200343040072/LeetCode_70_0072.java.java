/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (47.89%)
 * Likes:    864
 * Dislikes: 0
 * Total Accepted:    142.2K
 * Total Submissions: 296.4K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */

// @lc code=start
class Solution {
    //方法一：暴力法
    //在暴力法中，我们将会把所有可能爬的阶数进行组合，也就是 1 和 2 。
    // 而在每一步中我们都会继续调用 climbStairsclimbStairs 
    // 这个函数模拟爬 11 阶和 22 阶的情形，并返回两个函数的返回值之和。
    //climbStairs(i,n)=(i+1,n)+climbStairs(i+2,n)
    // 其中 ii 定义了当前阶数，而 nn 定义了目标阶数。

   /*  public int climbStairs(int n) {
         return climb_Stairs(0,n);
    }

    private int climb_Stairs(int i, int n) {
        if (i>n) {
           return 0; 
        }

        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1,n) + climb_Stairs(i + 2, n);
	} */
    
    // 方法二：在上一种方法中，我们计算每一步的结果时出现了冗余。
    // 另一种思路是，我们可以把每一步的结果存储在 memomemo 数组之中，
    // 每当函数再次被调用，我们就直接从 memomemo 数组返回结果。
    // 在 memomemo 数组的帮助下，我们得到了一个修复的递归树，其大小减少到 nn。

    /* public static int climbStairs(int n) {
        int memo[] =new int[n + 1];
        return climb_Stairs(0, n, memo);

    }

    private static int climb_Stairs(int i, int n, int[] memo) {
        if (i>n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    } */
    //方法三：动态规划
    // 第 i 阶可以由以下两种方法得到：
    // 在第 (i-1) 阶后向上爬一阶。
    // 在第 (i-2) 阶后向上爬 2 阶。
    // 所以到达第 i阶的方法总数就是到第 (i−1) 阶和第 (i−2) 阶的方法数之和。
    // 令 dp[i] 表示能到达第 i 阶的方法总数：
    // dp[i]=dp[i-1]+dp[i-2]
    
   /*  public static int climbStairs(int n) {
        if (n==1) {
            return 1;
        }
       
        int dp[]= new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    } */

    //方法四：斐波那契数
    // 在上述方法中，我们使用 dp 数组，其中 dp[i]=dp[i-1]+dp[i-2]。
    // 可以很容易通过分析得出 dp[i] 其实就是第 i 个斐波那契数。
    // Fib(n)=Fib(n-1)+Fib(n-2)
    // 现在我们必须找出以 1 和 2 作为第一项和第二项的斐波那契数列中的第 n 个数，也就是说 Fib(1)=1且 Fib(2)=2。
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        int third ;
        for (int i = 3; i <= n; i++) {
            third =first + second;
            first = second;
            second = third;
        }
        return second;

    }


}


