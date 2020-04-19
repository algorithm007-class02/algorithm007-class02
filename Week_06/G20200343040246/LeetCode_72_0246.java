package Week_06.G20200343040246;

public class LeetCode_72_0246 {
    public static void main(String[] args) {
        int ans = new LeetCode_72_0246().minDistance("horse", "ros");
        System.out.println(ans);
    }

    // 子问题：word1的子串变为word2的子串的最小编辑距离
    // 状态定义：dp[i][j] 表示word1第i个字符转变为word2第j个字符的最短编辑距离
    // DP方程：word1[i] == word2[j] ==> dp[i][j] = dp[i-1][j-1]    //字符相等不用做编辑
    // dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++) dp[i][0] = i;
        for(int j = 0; j < n + 1; j++) dp[0][j] = j;
        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}