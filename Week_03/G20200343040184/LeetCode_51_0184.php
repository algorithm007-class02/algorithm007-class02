//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=51 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 51. N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 链接：https://leetcode-cn.com/problems/n-queens/
 */
class Solution {
    private $col = [];
    private $pie = [];
    private $na = [];
    private $res = [];
    /**
     * 回溯法
     * @param Integer $n
     * @return String[][]
     */
    function solveNQueens($n) {
        $this->res = [];
        $this->dfs($n, 0, []);
        return $this->res;
    }
    function dfs($n, $row, $curr) {
        if ($row == $n) {
            $rows = [];
            foreach($curr as $col) {
                $rows[] = str_pad("", $col, '.')  . 'Q' . str_pad("", $n - $col - 1, '.');
            }
            $this->res[] = $rows;
            return;
        }
        foreach (range(0, $n - 1) as $col) {
            if ($this->col[$col] || $this->pie[$row + $col] || $this->na[$row - $col]) continue;
            $this->col[$col] = true; 
            $this->pie[$row + $col] = true; 
            $this->na[$row - $col] = true; 
            $curr[] = $col;
            $this->dfs($n, $row + 1, $curr);
            array_pop($curr);
            $this->col[$col] = false; 
            $this->pie[$row + $col] = false; 
            $this->na[$row - $col] = false; 
        }
    }
}
// @lc code=end
