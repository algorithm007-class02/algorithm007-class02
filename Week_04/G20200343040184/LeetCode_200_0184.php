//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=200 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 200. 岛屿数量
 * 链接：https://leetcode-cn.com/problems/number-of-islands/
 */
class Solution {

    /**
     * dfs
     * @param String[][] $grid
     * @return Integer
     */
    function numIslands($grid) {
        $n = count($grid);
        if ($n == 0) return 0;
        $m = count($grid[0]);
        $count = 0;
        for ($i = 0; $i < $n; $i++) {
            for ($j = 0; $j < $m; $j++) {
                if ($grid[$i][$j] == 1) {
                    $count++;
                    $this->bfs($grid, $i, $j, $n, $m);
                }
            }
        }
        return $count;
    }

    function dfs(&$grid, $i, $j, $n, $m)
    {
        if ($i < 0 || $i >= $n || $j < 0 || $j >= $m || $grid[$i][$j] != 1) return;
        $grid[$i][$j] = 0;
        $this->dfs($grid, $i + 1, $j, $n, $m);
        $this->dfs($grid, $i - 1, $j, $n, $m);
        $this->dfs($grid, $i, $j + 1, $n, $m);
        $this->dfs($grid, $i, $j - 1, $n, $m);
    }

    function bfs (&$grid, $i, $j, $n, $m) {
        $dx = [0, 1, 0, -1];
        $dy = [1, 0, -1, 0];
        $queue = [[$i, $j]];
        $grid[$i][$j] = 0;
        while ($queue) {
            [$i, $j] = array_shift($queue);
            for ($k = 0; $k < 4; $k++) {
                $ni = $i + $dx[$k];
                $nj = $j + $dy[$k];
                if ($ni >= 0 && $ni < $n && $nj >= 0 && $nj < $m && $grid[$ni][$nj] == 1) {
                    $queue[] = [$ni, $nj];
                    $grid[$ni][$nj] = 0;
                } 
            }
        }
    }
}
// @lc code=end
