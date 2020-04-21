//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。 
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


import java.awt.image.AffineTransformOp;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int len1 = t1.length;
        int len2 = t2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = t1[i - 1] == t2[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j],dp[i][j - 1]);
            }
        }
        return dp[len1][len2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * public int longestCommonSubsequence(String text1, String text2) {
 *         int len1 = text1.length();
 *         int len2 = text2.length();
 *         int[][] dp = new int[len1 + 1][len2 + 1];
 *         for (int i = 1; i <= len1; i++) {
 *             for (int j = 1; j <= len2; j++) {
 *                 dp[i][j] = (text1.charAt(i - 1) == text2.charAt(j - 1)) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i][j - 1],dp[i - 1][j]) ;
 *             }
 *         }
 *         return dp[len1][len2];
 *     }
 */
