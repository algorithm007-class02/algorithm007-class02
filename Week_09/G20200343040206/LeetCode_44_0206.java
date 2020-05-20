
//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
//
//
// 两个字符串完全匹配才算匹配成功。
//
// 说明:
//
//
// s 可能为空，且只包含从 a-z 的小写字母。
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
//
//
// 示例 1:
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
//
// 示例 2:
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
//
//
// 示例 3:
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
//
//
// 示例 4:
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
//
//
// 示例 5:
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输入: false
// Related Topics 贪心算法 字符串 动态规划 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_44_0206 {
    /**
     * dp[i][j]: 表示s的前i个字符和p的前j个字符是否匹配
     * ? : 可以直接代替一个字符
     * * ： 任意长度字符串，0个，或者直到下个字符匹配到
     *
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //初始化状态
        dp[0][0] = true;
        for (int i = 1; i <= p.length() ; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length() ; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
