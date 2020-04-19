//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=153 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * 
 * 示例 1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 
 * 示例 2:
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * 
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 链接：
 */
class Solution {

    /**
     * 方法一：二分法
     * @param Integer[] $nums
     * @return Integer
     */
    function findMin1($nums) {
        $left = 0;
        $right = count($nums) - 1;
        //注意边界问题
        if ($nums[$left] < $nums[$right] || $right == 0) return $nums[$left];
        while ($left < $right) {
            $mid = $left + floor(($right - $left) / 2);
            if ($nums[$mid] > $nums[$mid + 1]) return $nums[$mid + 1];
            if ($nums[$mid - 1] > $nums[$mid]) return $nums[$mid];
            if ($nums[$left] < $nums[$mid]) {
                $left = $mid + 1;
            } else {
                $right = $mid - 1;
            }
        }
    }

    /**
     * 方法二：二分法（精简写法）
     * @param Integer[] $nums
     * @return Integer
     */
    function findMin($nums) {
        $left = 0;
        $right = count($nums) - 1;
        while ($left < $right) {
            $mid = $left + floor(($right - $left) / 2);
           if ($nums[$mid] > $nums[$right]) {
                $left = $mid + 1;
            } else {
                $right = $mid;
            }
        }
        return $nums[$left];
    }
}
// @lc code=end
