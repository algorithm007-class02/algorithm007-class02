//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 进阶： 
//
// 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 字符串


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') left++;
        while (left <= right && s.charAt(right) == ' ') right--;

//        Deque<String> queue = new ArrayDeque<>();
        LinkedList<String> queue = new LinkedList<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
//                queue.offerFirst(word.toString());
                queue.push(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            left++;
        }
//        queue.offerFirst(word.toString());
        queue.push(word.toString());
//        return String.join(" ",queue);
        word.setLength(0);
        while (!queue.isEmpty()) {
            word.append(queue.pop());
            if (queue.peek() != null)
                word.append(" ");
        }
        return word.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * 调用API
 * public String reverseWords(String s) {
 *         s = s.trim();
 *         List<String> wordList = Arrays.asList(s.split("\\s+"));
 *         Collections.reverse(wordList);
 *         return String.join(" ",wordList);
 *     }
 */
/**
 * public String reverseWords(String s) {
 *         StringBuilder sb = trimSpaces(s);
 *         reverse(sb,0,sb.length() - 1);
 *         reverseEachWord(sb);
 *         return sb.toString();
 *     }
 *     StringBuilder trimSpaces(String s) {
 *         int left = 0, right = s.length() - 1;
 *         while (left <= right && s.charAt(left) == ' ') left++;
 *         while (left <= right && s.charAt(right) == ' ') right--;
 *
 *         StringBuilder sb = new StringBuilder();
 *         while (left <= right) {
 *             char c = s.charAt(left);
 *             if (c != ' ') sb.append(c);
 *             else if (sb.charAt(sb.length() - 1) != ' ') sb.append(c);
 *             left++;
 *         }
 *         return sb;
 *     }
 *     void reverse(StringBuilder sb,int left,int right) {
 *         while (left < right) {
 *             char temp = sb.charAt(left);
 *             sb.setCharAt(left++,sb.charAt(right));
 *             sb.setCharAt(right--,temp);
 *         }
 *     }
 *     void reverseEachWord(StringBuilder sb) {
 *         int n = sb.length();
 *         int start = 0, end = 0;
 *         while (start < n) {
 *             while (end < n && sb.charAt(end) != ' ')
 *                 end++;
 *             reverse(sb,start,end - 1);
 *             start = end + 1;
 *             end++;
 *         }
 *
 */
