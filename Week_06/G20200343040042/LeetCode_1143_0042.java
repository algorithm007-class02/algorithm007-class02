package com.yequan.leetcode.dp.longestCommonSubsequence_1143;

/**
 * //给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 * //
 * // 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * //例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * //
 * //
 * // 若这两个字符串没有公共子序列，则返回 0。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * // 输入：text1 = "abcde", text2 = "ace"
 * //输出：3
 * //解释：最长公共子序列是 "ace"，它的长度为 3。
 * //
 * //
 * // 示例 2:
 * //
 * // 输入：text1 = "abc", text2 = "abc"
 * //输出：3
 * //解释：最长公共子序列是 "abc"，它的长度为 3。
 * //
 * //
 * // 示例 3:
 * //
 * // 输入：text1 = "abc", text2 = "def"
 * //输出：0
 * //解释：两个字符串没有公共子序列，返回 0。
 * //
 * //
 * //
 * //
 * // 提示:
 * //
 * //
 * // 1 <= text1.length <= 1000
 * // 1 <= text2.length <= 1000
 * // 输入的字符串只含有小写英文字符。
 * //
 * // Related Topics 动态规划
 *
 * @author : Administrator
 * @date : 2020/4/19
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("ace", "abcde"));
    }

    /**
     * 动态规划
     * 使用二维数组存储第 text1中前 i 个字符串在 text2 前 j 个字符串中的最长公共子串长度
     * 分两种情况考虑:
     * 1.如果最后text1及其子串和text2及其子串中,最后一个字符相同,则求前一个子串的和+1
     * dp[i][j] = dp[i-1][j-1] + 1
     * 2.如果不相同,则求最大的一个
     * dp[i][j] = Max(dp[i][j-1],dp[i-1][j])
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[l1][l2];
    }

}
