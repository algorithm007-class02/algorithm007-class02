package com.alang.learn.week6;

/***
 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

 示例 1:

 输入: "(()"
 输出: 2
 解释: 最长有效括号子串为 "()"
 示例 2:

 输入: ")()())"
 输出: 4
 解释: 最长有效括号子串为 "()()"

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_32_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("(()"));
        System.out.println(solution.longestValidParentheses(")()())"));
    }

    static class Solution {
        public int longestValidParentheses(String s) {
            if (s == null || s.length() == 0) return 0;
            //dp【i】 代表从0到i的最大有效子串长度
            int length = s.length();
            int answer = 0;
            int[] dp = new int[length];
            for (int i = 1; i < length; i++) {
                if (s.charAt(i) == ')') {//)
                    if (s.charAt(i - 1) == '(') {//()
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {//(())
                        dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    answer = Math.max(answer, dp[i]);
                }
            }
            return answer;
        }
    }
}
