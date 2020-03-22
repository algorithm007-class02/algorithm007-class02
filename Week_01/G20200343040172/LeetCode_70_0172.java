package Week_01.G20200343040172;

/**
 * LeetCode-70 爬楼梯
 */

public class LeetCode_70_0172 {


    /**
     * 第一次接触动态规划的题目，干脆直接背LeetCode的代码
     *
     * 动态规划：
     * 本问题其实常规解法可以分成多个子问题，爬第n阶楼梯的方法数量，等于 2 部分之和，等于爬上n-1阶楼梯和n-2阶楼梯
     * 爬上 n-1阶楼梯的方法数量。因为再爬1阶就能到第n阶
     * 爬上 n-2阶楼梯的方法数量，因为再爬2阶就能到第n阶
     * 所以我们得到公式 dp[n] = dp[n-1] + dp[n-2]dp[n]=dp[n−1]+dp[n−2]
     * 同时需要初始化 dp[0]=1 和 dp[1]=1
     * 时间复杂度：O(n)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
