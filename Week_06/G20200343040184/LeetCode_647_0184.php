//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=647 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * 
 * 示例 1:
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 
 * 示例 2:
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 注意:
 * 输入的字符串长度不会超过1000。
 * 
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 */
class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function countSubstrings1($s) {
        $dp = [];
        $ans = 0;
        $n = strlen($s);
        for ($j = 0; $j < $n; $j++) {
            for ($i = 0; $i <= $j; $i++) {
                if ($s[$i] == $s[$j] && ($j - $i < 2 || $dp[$i + 1][$j -1])) {
                    $dp[$i][$j] = true;
                    $ans++;
                }
            }
        }
        return $ans;
    }
    //方法一：从中心往两侧延伸【通过】
    function countSubstrings($s) {
        $ans = 0;
        $n = strlen($s);
       	for ($center = 0; $center <= 2*$n-1; ++$center) {
            $left = intval($center / 2);
            $right = $left + $center % 2;
            while ($left >=0 && $right < $n && $s[$left] == $s[$right]) {
                $ans++;
                $left--;
                $right++;
            }
        }
        return $ans;
    } 	
}
// @lc code=end
