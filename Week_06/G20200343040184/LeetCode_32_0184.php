//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=32 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 */
class Solution {

    /**
     *  方法一：栈
     * @param String $s
     * @return Integer
     */
    function longestValidParentheses1($s) {
        $stack = new SplStack();
        $stack->push(-1);
        $length = strlen($s);
        $maxans = 0;

        for ($i = 0; $i < $length; $i++) {
            if ($s[$i] == "(") {
                $stack->push($i);
            } else {
                $stack->pop();
                // 标记分割点
                if ($stack->isEmpty()) {
                    $stack->push($i);
                } else {
                    // 计算最大的成对数量
                    $maxans = max($maxans, $i - $stack->top());
                }
            }
        }
        return $maxans;
    }
    
    //动态规划
    function longestValidParentheses($s) {
        $maxans = 0;
        $dp = [];
        for ($i = 1; $i < strlen($s); $i++) {
            if ($s[$i] == ')') {
                if ($s[$i - 1] == '(') {
                    $dp[$i] = ($i >= 2 ? $dp[$i - 2] : 0) + 2;
                } else if ($i - $dp[$i - 1] > 0 && $s[$i - $dp[$i - 1] - 1] == '(') {
                    $dp[$i] = $dp[$i - 1] + (($i - $dp[$i - 1]) >= 2 ? $dp[$i - $dp[$i - 1] - 2] : 0) + 2;
                }
                $maxans = max($maxans, $dp[$i]);
            }
        }
        return $maxans;
    }
}
// @lc code=end
