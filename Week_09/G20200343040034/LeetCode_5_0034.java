package com.alang.learn.week9;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_5_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome1("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome1("cbbd"));
    }

    static class Solution {

        public String longestPalindrome(String s) {
            String max = "";
            if (s == null || s.length() == 0) return "";
            int length = s.length();
            if (length == 1) {
                return s;
            }
            boolean[][] palindrome = new boolean[length + 1][length + 1];
            for (int j = 0; j <= length; j++) {
                for (int i = j; i >= 0; i--) {
                    if (i == j || i == j - 1) {
                        palindrome[i][j] = true;
                    } else {
                        palindrome[i][j] = palindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j - 1);
                    }
                    if (i != j && palindrome[i][j] && (j - i) > max.length()) {
                        max = s.substring(i, j);
                    }
                }
            }
            return max;
        }

        public String longestPalindrome1(String s) {
            String max = "";
            if (s == null || s.length() == 0) return "";
            if (s.length() == 1) {
                return s;
            }
            for (int i = 0, n = s.length(); i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    String sub = s.substring(i, j);
                    if (isPalindrome(sub) && (j - i) > max.length()) {
                        max = sub;
                    }
                }
            }
            return max;
        }

        boolean isPalindrome(String s) {
            int length = s.length();
            if (length == 1) {
                return true;
            }
            int harf = length >> 1;
            for (int i = 0; i < harf + 1; i++) {
                if (length - i > 0 && s.charAt(i) != s.charAt(length - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
