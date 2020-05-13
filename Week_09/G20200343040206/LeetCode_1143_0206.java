
//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
//
//
// 若这两个字符串没有公共子序列，则返回 0。
//
//
//
// 示例 1:
//
// 输入：text1 = "abcde", text2 = "ace"
//输出：3
//解释：最长公共子序列是 "ace"，它的长度为 3。
//
//
// 示例 2:
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
//
//
// 示例 3:
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
//
//
//
//
// 提示:
//
//
// 1 <= text1.length <= 1000
// 1 <= text2.length <= 1000
// 输入的字符串只含有小写英文字符。
//
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_1143_0206 {
    /**
     * 最长公共子序列
     * 子序列？
     * 如何找最长
     * 逐步比较，记录最长
     * <p>
     * 动态规划：s,t
     * 1、dp[i][j]:
     * i表示从起始位置到s的第i位
     * j表示从起始位置到t的第j位
     * dp[i][j]表示目前位置的最长子序列长度
     * <p>
     * 2、dp[i][j] =
     * if s[i] == t[j] :   dp[i-1][j-1] + 1
     * if s[i] != t[j] :   max(dp[i][j-1],dp[i-1][j])
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        //第i，j个字符，不是下标
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[text1.length() + 1][text2.length() + 1];
    }

    /**
     * 空间压缩，一维dp[]
     * 按排来计算，相当于缓存了中间数据
     *
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence_2(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        //第i，j个字符，不是下标
        int[] dp = new int[text2.length() + 1];
        int temp = 0;
        for (int i = 1; i <= text1.length(); i++) {
            int last = 0;
            for (int j = 1; j <= text2.length(); j++) {
                temp = dp[j];
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[j] = last + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], temp);
                }
                last = temp;
            }
        }

        return dp[text2.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
