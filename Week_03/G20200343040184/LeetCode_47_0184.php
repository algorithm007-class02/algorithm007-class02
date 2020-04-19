//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=47 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 链接：https://leetcode-cn.com/problems/permutations-ii/
 */
class Solution {
    private $output = [];
    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function permuteUnique($nums) {
       $count = count($nums);
       if ($count == 0) return [];
       sort($nums);
       $this->backtrack($nums, $count, 0);
       return $this->output;
    }

    function backtrack($nums, $count, $level, $visited = [], $res = []) {
        if ($level == $count) {
            $this->output[] = $res;
            return;
        }
        for ($i = 0; $i < $count; $i++) {
            if ($visited[$i]) continue;
            if ($i > 0 && $nums[$i] == $nums[$i - 1] && !$visited[$i - 1]) continue;
            $res[] = $nums[$i];
            $visited[$i] = true;
            $this->backtrack($nums, $count, $level + 1, $used, $res);
            $visited[$i] = false;
            array_pop($res);
        }
    }
}
// @lc code=end
