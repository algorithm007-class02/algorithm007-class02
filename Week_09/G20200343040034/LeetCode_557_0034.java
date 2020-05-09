package com.alang.learn.week9;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_557_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }

    static class Solution {
        public String reverseWords(String s) {
            if (s == null || s.length() == 0) return "";
            int start = 0;
            int end = s.length() - 1;
            while (start < end && s.charAt(start) == ' ') start++;
            while (start < end && s.charAt(end) == ' ') end--;
            int wordStartIndex = start;
            Deque<String> stack = new ArrayDeque();
            while (start < end) {
                if (s.charAt(start) == ' ') {
                    stack.offer(reverse(s.substring(wordStartIndex, start)));
                    wordStartIndex = start + 1;
                }
                start++;
            }
            if (wordStartIndex != start || s.charAt(wordStartIndex) != ' ') {
                stack.offer(reverse(s.substring(wordStartIndex, start + 1)));
            }
            return String.join(" ", stack);
        }

        public String reverse(String s) {
            char[] chars = s.toCharArray();
            int left = 0, right = chars.length - 1;
            char temp;
            while (left < right) {
                temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
            return String.valueOf(chars);
        }
    }
}
