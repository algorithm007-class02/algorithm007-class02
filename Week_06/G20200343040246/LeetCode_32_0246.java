package Week_06.G20200343040246;

public class LeetCode_32_0246 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_32_0246().longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int ans = 0, n = s.length();
        int[] dp = new int[n];
        for(int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}