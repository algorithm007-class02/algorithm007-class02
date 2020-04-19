/**
 * 最长公共子序列（Longest Common Subsequence，LCS）
 */
public class LeetCode_1143_0222 {

    /**
     * 用dp[i][j]表示第一个字符串的第1至i号位字符部分与第二个字符串的第1至j号位字符部分的LCS长度
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();
        int len1 = char1.length;
        int len2 = char2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = char1[i - 1] == char2[j - 1] ? (dp[i - 1][j - 1] + 1) : Math.max(dp[i - 1][j], dp[i][ j - 1]);
            }
        }
        return dp[len1][len2];
    }

    /**
     * 优化方法1
     * 计算dp[i][j]只用到了其左方、左上方和上方数据
     * 逐列地计算dp[][]数组的值，这样可以把二维数组变为一维数组，只存储一列数据即可
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequenceRe(String text1, String text2) {
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();
        int len1 = char1.length;
        int len2 = char2.length;
        int[] dp = new int[len2 + 1];
        int ans = 0;
        for (int i = 1; i <= len1; i++) {
            int last = 0;
            for (int j = 1; j <= len2; j++) {
                int temp = dp[j];
                dp[j] = char2[j - 1] == char1[i - 1] ? (last + 1) : Math.max(dp[j - 1], dp[j]);
                ans = Math.max(ans, dp[j]);
                last = temp;
            }
        }
        return ans;
    }



}