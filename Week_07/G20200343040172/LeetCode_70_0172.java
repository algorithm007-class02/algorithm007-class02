package week07.g20200343040172;

public class LeetCode_70_0172 {
    /**
     * 使用记忆化的递归
     */
    class Solution1 {
        public int climbStairs(int n) {
            int[] memo = new int[n + 2];
            memo[1] = 1;
            memo[2] = 2;
            return recursion(n, memo);
        }

        public int recursion(int n, int[] memo) {
            if (n == 2 || n == 1) {
                return memo[n];
            }
            if (memo[n - 1] != 0 && memo[n - 2] != 0) {
                memo[n] = memo[n - 1] + memo[n - 2];
            } else {
                memo[n] = recursion(n - 1, memo) + recursion(n - 2, memo);
            }
            return memo[n];
        }
    }
}
