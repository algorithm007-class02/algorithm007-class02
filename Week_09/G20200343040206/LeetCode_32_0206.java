
//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
// 示例 1:
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
//
//
// 示例 2:
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
//
// Related Topics 字符串 动态规划


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_32_0206 {
    /**
     * 4中方法
     * 1、暴力遍历所有子字符串，然后一一判断子字符串是否满足要求
     * 2、栈
     * 3、动态规划
     * 4、双指针扫描
     *
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    /**
     * 用栈记录扫描到目前位置，子字符串的有效性，同时能的最长有效字符串长度
     * 首先将-1放入栈顶
     * '('：下标放入栈中
     * ')'：弹出栈顶元素，并将当前元素下标与弹出元素下标做差，得出当前有效括号字符串的长度
     * @param s
     * @return
     */
    public int longestValidParentheses_2(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()){
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    /**
     * 根据栈的思想，可以使用动态规划
     * dp[i]，表示前i个字符串，最长有效子串的长度
     * ...( :  dp[i] = 0
     * ...()： dp[i] = dp[i-2] + 2
     * ...)): dp[i] = dp[i-1] + dp[i-dp[i-1]-2](dp[i-1])
     *
     * @param s
     * @return
     */
    public int longestValidParentheses_3(String s) {
       int maxLen = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = 2 + (i - 2 > 0 ? dp[i - 2] : 0);
                } else if ( i - dp[i-1] - 1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
                    dp[i] = (i - dp[i-1] -2 >= 0 ? dp[i-dp[i-1]-2] : 0) + dp[i-1] + 2;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    /**
     * 双记录数，记录（和）的个数
     *
     * @param s
     * @return
     */
    public int longestValidParentheses_4(String s) {
        int left = 0, right = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, right * 2);
            } else if (right > left) {
                left = right = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, left * 2);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
