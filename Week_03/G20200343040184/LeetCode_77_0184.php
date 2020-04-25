//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=77 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 链接：https://leetcode-cn.com/problems/combinations/
 */
class Solution {
    private $n;
    private $k;
    private $result = [];
    /**
     * 回溯法
     * @param Integer $n
     * @param Integer $k
     * @return Integer[][]
     */
    function combine($n, $k) {
        $this->n = $n;
        $this->k = $k;
        $this->backtrack(1, []);
        return $this->result;
    }

    function backtrack($first , $curr) {
        if (count($curr) == $this->k) {
            $this->result[] = $curr;
            return;
        }
        // 此时剩余可选数字个数 $n - $i + 1
        // 所需数字个数 $k - count($list)
        //for ($i = $first; $i <= $this->n; $i++) {
        for ($i = $first; $this->n - $i + 1 >= $this->k - count($curr); $i++) {
            $curr[] = $i;
            $this->backtrack($i + 1, $curr);
            array_pop($curr);
        }
    }
}
// @lc code=end
