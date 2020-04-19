//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=169 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 链接：https://leetcode-cn.com/problems/majority-element/
 */
class Solution {

    /**
     * 方法一：排序法
     * 方法二：哈希表计数法
     * 方法三：分治法
     * 方法四：摩尔投票
     * 方法五：随机选取法
     * @param Integer[] $nums
     * @return Integer
     * 分治法
     */
    function majorityElement($nums) {
        return $this->dac($nums, 0, count($nums) -1);   
    }
    function dac($nums, $l, $r) {
        if ($l == $r) return $nums[$l];
        $mid = $l + intdiv($r - $l, 2);
        $left = $this->dac($nums, $l, $mid);
        $right = $this->dac($nums, $mid + 1, $r);
        if ($left == $right) return $left;
        $left_count = $this->countInRange($nums, $left, $l, $r);
        $right_count = $this->countInRange($nums, $right, $l, $r);
        return $left_count > $right_count ? $left : $right;
    }
    function countInRange($nums, $num, $l, $r) {
        $count = 0;
        for($i = $l; $i <= $r; $i++){
            if ($num == $nums[$i]) $count++;
        }
        return $count;
    }
}
// @lc code=end
