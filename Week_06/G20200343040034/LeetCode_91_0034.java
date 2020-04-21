package com.alang.learn.week6;

/***

 一条包含字母 A-Z 的消息通过以下方式进行了编码：

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 给定一个只包含数字的非空字符串，请计算解码方法的总数。

 示例 1:

 输入: "12"
 输出: 2
 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 示例 2:

 输入: "226"
 输出: 3
 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/decode-ways
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_91_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("12"));
        System.out.println(solution.numDecodings("226"));
        System.out.println(solution.numDecodings("327"));
    }

    static class Solution {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) return 0;
            int[] dp = new int[s.length() + 1];
            if (s.charAt(0) == '0') return 0;
            //dp[n] 代表 前n个字符串有多少种解码方法
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 1, l = s.length(); i < l; i++) {
                char cur = s.charAt(i);
                if (cur != '0') {//当前可被拆分
                    dp[i + 1] = dp[i];
                }
                char last = s.charAt(i - 1);
                if ((last == '2' && cur < '7') || (last < '2' && last > '0')) {//可以和前一位组合
                    dp[i + 1] += dp[i - 1];
                }
            }
            return dp[s.length()];
        }
    }
}
