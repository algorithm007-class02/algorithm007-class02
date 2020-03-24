//<?php
/**
 * @lc app=leetcode.cn id=242 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 * 链接：https://leetcode-cn.com/problems/valid-anagram/
 */
class Solution {

    /**
     * 方法一：排序比较
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    function isAnagram1($s, $t) {
        $s = str_split($s);
        $t = str_split($t);
        sort($s);
        sort($t);
        return $s == $t;
    }

    /**
     * 方法二：统计字母出现的次数比较
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    function isAnagram2($s, $t) {
        //return array_count_values(str_split($s, 1)) == array_count_values(str_split($t, 1));
        return count_chars($s, 1) == count_chars($t, 1);
    }

    /**
     * 方法三：哈希表
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    function isAnagram($s, $t) {
        $len = strlen($s);
        if ($len != strlen($t)) return false;
        $map = [];
        for ($i = 0; $i < $len; $i++) {
            if (!isset($map[$s[$i]])) $map[$s[$i]] = 0;
            if (!isset($map[$t[$i]])) $map[$t[$i]] = 0;
            $map[$s[$i]]++;
            $map[$t[$i]]--;
        }
        foreach ($map as $c) {
            if ($c) return false; 
        }
        return true;
    }
}
// @lc code=end