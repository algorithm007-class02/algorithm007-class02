/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (70.03%)
 * Likes:    178
 * Dislikes: 0
 * Total Accepted:    54.3K
 * Total Submissions: 76.9K
 * Testcase Example:  '"Let\'s take LeetCode contest"'
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 
 * 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * 
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        char[] a = s.toCharArray();
        int i = 0, j = 0;
        while (j < a.length) {
            while (j < a.length && a[j] != ' ') j++;
            reverse(a, i, j - 1);
            i = j + 1;
            j++;
        }
        return String.valueOf(a);
    }

    private void reverse(char[] a, int start, int end) {
        while (start < end) {
            char tmp = a[start];
            a[start++] = a[end];
            a[end--] = tmp;
        }
    }
}
// @lc code=end
