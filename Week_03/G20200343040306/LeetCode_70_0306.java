/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (48.09%)
 * Likes:    893
 * Dislikes: 0
 * Total Accepted:    159.6K
 * Total Submissions: 331.5K
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
    /**
     * 递归 + 填表，既使用了递归，又减少了重复计算速度
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] dict = new int[n];
        if (n < 0) return 0;
        if (n <= 2) return n;
        dict[0] = 1;
        dict[1] = 2;
        return helper(n, dict);
    }

    private int helper(int n, int[] dict) {
        if (n < 0) return 0;
        if (n <= 2) return n;
        helper(n - 1, dict);
        dict[n-1] = dict[n-2] + dict[n-3];
        return dict[n-1];
    }
}
// @lc code=end

