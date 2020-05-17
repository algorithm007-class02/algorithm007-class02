/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (23.28%)
 * Likes:    346
 * Dislikes: 0
 * Total Accepted:    43.3K
 * Total Submissions: 184.9K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 1) {
            return s.equals("0") ? 0 : 1;
        }
        int[] dp = new int[len + 1];
        char[] chars = s.toCharArray();
        // 之所以 dp[0] = 1，是为了计算 dp[2] 的时候相当于 dp[2] = dp[1] + 1;
        // 比如 12 就有两种解法。
        dp[0] = 1;
        dp[1] = chars[0] == '0' ? 0 : 1;

        for (int i = 1; i < len; i++) {
            if (chars[i] == '0') {
                if (chars[i - 1] == '1' || chars[i - 1] == '2') {
                    dp[i + 1] = dp[i - 1];
                } else {
                    dp[i + 1] = 0;
                }
            } else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && '1' <= chars[i] && chars[i] <= '6')) {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else {
                // 比如 27, 那麼就只有 2， 7 这一种
                dp[i + 1] = dp[i];
            }
        }
        return dp[len];
    }
}
// @lc code=end
