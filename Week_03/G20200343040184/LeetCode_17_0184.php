//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=17 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
class Solution {

    /**
     * @param String $digits
     * @return String[]
     */
    function letterCombinations($digits) {
        $map = [
            2 => 'abc',
            3 => 'def',
            4 => 'ghi',
            5 => 'jkl',
            6 => 'mno',
            7 => 'pqrs',
            8 => 'tuv',
            9 => 'wxyz',
        ];
        $len = strlen($digits);
        $res = [];
        if ($len) {
            $this->backtrack($res, $digits, 0, $len, "", $map);
        }
        return $res;
    }
    function backtrack(&$res, $digits, $level, $len, $s, $map) {
        if ($level == $len) {
            $res[] = $s;
            return;
        }
        $num = $digits[$level];
        $letters = $map[$num];
        for ($i = 0; $i < strlen($letters); $i++) {
            $this->backtrack($res, $digits, $level + 1, $len, $s . $letters[$i], $map);
        }
    }
}
// @lc code=end
