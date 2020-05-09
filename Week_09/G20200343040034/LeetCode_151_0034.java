package com.alang.learn.week9;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_151_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
        System.out.println(solution.reverseWords("  hello world!  "));
        System.out.println(solution.reverseWords("a good   example"));
    }

    static class Solution {
        public String reverseWords(String s) {
            if(s == null || s.length() == 0) return "";
            int start = 0;
            int end = s.length()-1;
            while(start<end && s.charAt(start) == ' ') start++;
            while(start<end && s.charAt(end) == ' ') end--;
            int wordStartIndex = start;
            Deque<String> stack = new ArrayDeque<>();
            while(start < end){
                if(s.charAt(start) == ' '){
                    if(start-wordStartIndex > 0){
                        stack.offerFirst(s.substring(wordStartIndex,start));
                    }
                    wordStartIndex = start+1;
                }
                start++;
            }
            if(wordStartIndex != start || s.charAt(wordStartIndex) != ' '){
                stack.offerFirst(s.substring(wordStartIndex,start+1));
            }
            return String.join(" ",stack);
        }
    }
}
