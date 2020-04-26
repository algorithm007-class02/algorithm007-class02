//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=221 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 示例:
 * 输入: 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 * 
 * 链接：https://leetcode-cn.com/problems/maximal-square
 */
class Solution {

    /**
     * 动态规划
     * dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
     * @param String[][] $matrix
     * @return Integer
     */
    function maximalSquare1($matrix) {
		$m = count($matrix);
        if ($m == 0) return 0;
        $n = count($matrix[0]);
        $dp  = [];
        $maxsqlen = 0;
        for ($i = 0; $i <= $m; $i++) $dp[] = array_fill(0, $n + 1, 0);
        for ($i = 1; $i <= $m; $i++) {
            for ($j = 1; $j <= $n; $j++) {
                if ($matrix[$i - 1][$j - 1] == 1) {
                    $dp[$i][$j] = min($dp[$i][$j - 1], $dp[$i - 1][$j], $dp[$i - 1][$j - 1]) + 1;
                    $maxsqlen = max($maxsqlen, $dp[$i][$j]);
                }
            }
        }
        return $maxsqlen * $maxsqlen;
    }
    //空间优化使用一维dp
    function maximalSquare($matrix) {
		$m = count($matrix);
        if ($m == 0) return 0;
        $n = count($matrix[0]);
        $maxsqlen = $pre = 0;
        $dp = array_fill(0, $n + 1, 0);
        for ($i = 1; $i <= $m; $i++) {
            for ($j = 1; $j <= $n; $j++) {
                $tmp = $dp[$j];
                if ($matrix[$i - 1][$j - 1] == 1) {
                    $dp[$j] = min($dp[$j - 1], $dp[$j], $pre) + 1;
                    $maxsqlen = max($maxsqlen, $dp[$j]);
                } else {
                    $dp[$j] = 0;
                }
                $pre = $tmp;
            }
        }
        return $maxsqlen * $maxsqlen;
    }
}
// @lc code=end
