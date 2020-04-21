//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 
//
// 示例 1: 
//
// 
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
// 
//
// 示例 2: 
//
// 
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 注意: 
//
// 
// 输入的字符串长度不会超过1000。 
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length * 2 - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                left--;
                right++;
                result++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * public int countSubstrings(String s) {
 *         char[] chars = s.toCharArray();
 *         int len = chars.length;
 *         int result = 0;
 *         boolean[][] flag = new boolean[len][len];
 *         for (int j = 0; j < len; j++) {
 *             for (int i = j; i >= 0; i--) {
 *                 if (chars[i] == chars[j] && (j - i < 2 || flag[i + 1][j - 1])) {
 *                     flag[i][j] = true;
 *                     result++;
 *                 }
 *             }
 *         }
 *         return result;
 *     }
 */
