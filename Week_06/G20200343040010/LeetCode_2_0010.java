package com.algorithm.fifthWeek;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class NumDecodings {

    public static void main(String[] args) {
        System.out.println(numDecodings("1010"));
    }

    public static int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int pre = 1, curr = 1;
        for (int i = 1; i < s.length(); i++) {
            int tmp = curr;
            if (s.charAt(i) == '0')
                //当前元素为0，那么查看之前的元素是否满足条件，满足的话，将前一个元素处理过之前的状态赋值给当前元素，类似于爬楼梯，当前的阶层不算
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') curr = pre;
                else return 0;
            else if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6'))
                //当前元素不为0时，前一个元素与当前元素满足条件时，类似于爬楼梯，做累加
                curr = curr + pre;
            pre = tmp;
        }
        return curr;
    }
}
