//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=46 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 链接：https://leetcode-cn.com/problems/permutations/
 */
class Solution {

    /**
     * 回溯法
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function permute($nums) {
        $res = [];
        $count = count($nums);
        $this->backtrack(0, $count, $nums, $res);
        return $res;
    }
    function backtrack($level, $count, $nums,&$res) {
        if ($level == $count) {
            $res[] = $nums;
            return;
        }
        for ($i = $level; $i < $count; $i++) {
            $this->swap($nums, $i, $level);
            $this->backtrack($level + 1, $count, $nums, $res);
            $this->swap($nums, $i, $level);
        }
    }
    function swap(&$nums, $i, $j) {
        $tmp = $nums[$i];
        $nums[$i] = $nums[$j];
        $nums[$j] = $tmp;
    }
}
// @lc code=end
