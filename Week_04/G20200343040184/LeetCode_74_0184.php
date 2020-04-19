//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=74 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 
 * 示例 2:
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 */
class Solution {

    /**
     * 方法一：二分法
     * @param Integer[][] $matrix
     * @param Integer $target
     * @return Boolean
     */
    function searchMatrix($matrix, $target) {
        $n = count($matrix);
        if ($n == 0) return false;
        $m = count($matrix[0]);
        $left = 0;
        $right = $n * $m - 1;
        while ($left <= $right) {
            $mid = $left + intdiv($right - $left, 2);
            if ($matrix[intval($mid / $m)][$mid % $m] == $target) return true;
            if ($matrix[intval($mid / $m)][$mid % $m] < $target) {
                $left = $mid + 1;
            } else {
                $right = $mid - 1;
            }
        }
        return false;
    }
}
// @lc code=end
