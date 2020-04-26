//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=64 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 */
class Solution {

    /**
     * dp(自顶向下)
     * @param Integer[][] $grid
     * @return Integer
     */
    function minPathSum1($grid) {
        $m = count($grid);
        if ($m == 0) return 0;
        $n = count($grid[0]);
        $dp = [];
        $dp[0][0] = $grid[0][0];
        //初始化第一行
        for($i = 1; $i < $n; $i++) {
            $dp[0][$i] = $dp[0][$i - 1] + $grid[0][$i];
        }
        for ($i = 1; $i < $m; $i++) {
            $dp[$i][0] = $dp[$i - 1][0] + $grid[$i][0];
            for ($j = 1; $j < $n; $j++) {
                $dp[$i][$j] = min($dp[$i][$j - 1], $dp[$i - 1][$j]) + $grid[$i][$j];
            }
        }
		return $dp[$m - 1][$n - 1];
    }
    //dp 降维
    function minPathSum($grid) {
        $m = count($grid);
        if ($m == 0) return 0;
        $n = count($grid[0]);
        $dp = [];
        $dp[0] = $grid[0][0];
        //初始化第一行
        for($i = 1; $i < $n; $i++) {
            $dp[$i] = $dp[$i - 1] + $grid[0][$i];
        }
        for ($i = 1; $i < $m; $i++) {
            $dp[0] = $dp[0] + $grid[$i][0];
            for ($j = 1; $j < $n; $j++) {
                $dp[$j] = min($dp[$j - 1], $dp[$j]) + $grid[$i][$j];
            }
        }
		return $dp[$n - 1];
    }
}
// @lc code=end
