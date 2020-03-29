package level1;

public class Solution70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        // 动态规划
        // dp[i] = dp[i-1] + dp[i-2]
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbStairs2(int n) {
        // 斐波那契数列
        // fib(n) = fib(n-1) + fib(n-2)
        int first = 1;
        int second = 2;
        if (n == 1)
            return first;
        if (n == 2)
            return second;
        for (int i = 3; i <= n; i++) {
            int third = second + first;
            first = second;
            second = third;
        }
        return second;
    }

    public static int climb(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb(i + 1, n) + climb(i + 2, n);
    }
}
