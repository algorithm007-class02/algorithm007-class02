package Week_06.G20200343040246;

public class LeetCode_91_0246 {
    public static void main(String[] args) {
        int ans = new LeetCode_91_0246().numDecodings("226");
        System.out.println(ans);
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len +1];
        dp[len] = 1;
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        for(int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    // recursion
    public int numDecodings1(String s) {
        if (s == null || s.length() == 0) return 0;
        return dfs(s, 0);
    }

    public int dfs(String s, int start) {
        if (s.length() == start) return 1;
        if (s.charAt(start) == '0') return 0;
        int ans1 = dfs(s, start + 1);
        int ans2 = 0;
        if (start < s.length() - 1) {
            if ((s.charAt(start) - '0') * 10 + (s.charAt(start + 1) - '0') <= 26) {
                ans2 = dfs(s, start + 2);
            }
        }
        return ans1 + ans2;
    }
}