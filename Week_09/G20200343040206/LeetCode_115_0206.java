
//给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
//
// 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是）
//
// 题目数据保证答案符合 32 位带符号整数范围。
//
//
//
// 示例 1：
//
// 输入：S = "rabbbit", T = "rabbit"
//输出：3
//解释：
//
//如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
//
//
// 示例 2：
//
// 输入：S = "babgbag", T = "bag"
//输出：5
//解释：
//
//如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_115_0206 {
    /**
     * dp[i][j]表示s的前i个字符串中子序列中t的前j个字符串的个数
     * dp[i][j] =
     * if s[i] == t[j]
     *
     *
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length() ; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
