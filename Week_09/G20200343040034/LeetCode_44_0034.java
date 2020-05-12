package com.alang.learn.week9;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 * <p>
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 * <p>
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 * <p>
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_44_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("aa", "*"));
        System.out.println(solution.isMatch("cb", "*a"));
        System.out.println(solution.isMatch("adceb", "*a*b"));
        System.out.println(solution.isMatch("acdcb", "a*c?b"));
    }

    static class Solution {
        public boolean isMatch(String s, String p) {
            if ("*".equals(p)) {
                return true;
            }
            if (s == null) {
                return false;
            }
            if (p == null) {
                return false;
            }
            if ("".equals(p)) {
                return "".equals(s);
            }
            int pl = p.length();
            int sl = s.length();
            boolean[][] isMatch = new boolean[sl + 1][pl + 1];
            isMatch[0][0] = true;
            for (int i = 0; i < pl; i++) {
                isMatch[0][i + 1] = isMatch[0][i] && p.charAt(i) == '*';
            }
            for (int i = 0; i < sl; i++) {
                for (int j = 0; j < pl; j++) {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                        isMatch[i + 1][j + 1] = isMatch[i][j];
                    } else if (p.charAt(j) == '*') {
                        isMatch[i + 1][j + 1] = isMatch[i][j + 1] || isMatch[i + 1][j];
                    }
                }
            }
            return isMatch[sl][pl];
        }
    }
}
