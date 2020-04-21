package com.alang.learn.week6;

import java.util.Arrays;

/***
 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

 示例 1:

 输入: "abc"
 输出: 3
 解释: 三个回文子串: "a", "b", "c".
 示例 2:

 输入: "aaa"
 输出: 6
 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/palindromic-substrings
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_647_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("aaabcaaa"));
        System.out.println(solution.countSubstrings1("aaabcaaa"));
    }

    static class Solution {
        public int countSubstrings(String s) {
            int length = s.length();
            boolean[] dp = new boolean[length];
            int answer = 0;
            for (int i = length - 1; i >= 0; i--) {
                for (int j = length - 1; j >= i; j--) {
                    dp[j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[j - 1]);
                    if (dp[j]) answer++;
                }
            }
            return answer;
        }

        public int countSubstrings1(String s) {
            int length = s.length();
            boolean[][] dp = new boolean[length][length];
            int answer = 0;
            for (int l = 1; l <= length; l++) {
                for (int i = 0; i + l - 1 < length; i++) {
                    int j = i + l - 1;
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                    if (dp[i][j]) answer++;
                }
            }
            return answer;
        }
    }
}
