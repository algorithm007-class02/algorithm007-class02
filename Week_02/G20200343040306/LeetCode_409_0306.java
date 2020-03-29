/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 *
 * https://leetcode-cn.com/problems/longest-palindrome/description/
 *
 * algorithms
 * Easy (52.18%)
 * Likes:    125
 * Dislikes: 0
 * Total Accepted:    25.3K
 * Total Submissions: 47.1K
 * Testcase Example:  '"abccccdd"'
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * 
 * 示例 1: 
 * 
 * 
 * 输入:
 * "abccccdd"
 * 
 * 输出:
 * 7
 * 
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        int res = 0;
        int[] chars = new int[52];
        boolean hasOdd = true;
        for (char c: s.toCharArray()) {
            if (c - 'A' < 26) {
                chars[c - 'A'] += 1;
            } else {
                chars[c -'a' + 26] += 1;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] % 2 == 0) {
                res += chars[i];
            } else {
                res += chars[i] - 1;
                if (hasOdd) {
                    res += 1;
                    hasOdd = false;
                }
            }
        }
        return res;
    }
}
// @lc code=end

