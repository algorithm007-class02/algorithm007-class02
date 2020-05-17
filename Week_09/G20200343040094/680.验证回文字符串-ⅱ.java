/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 *
 * https://leetcode-cn.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (36.53%)
 * Likes:    149
 * Dislikes: 0
 * Total Accepted:    20.2K
 * Total Submissions: 55K
 * Testcase Example:  '"aba"'
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "aba"
 * 输出: True
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 
 * 
 * 注意:
 * 
 * 
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        char[] a = s.toCharArray();
        for (int i = 0, j = a.length - 1; i < j; ++i, --j) {
            if (a[i] != a[j]) {
                return isPalindrome(a, i + 1, j) || isPalindrome(a, i, j - 1);
            }
        }
        return true;
    }
    private boolean isPalindrome(char[] a, int i, int j) {
        while (i < j) {
            if (a[i++] != a[j--]) return false;
        }
        return true;
    }
}
// @lc code=end

