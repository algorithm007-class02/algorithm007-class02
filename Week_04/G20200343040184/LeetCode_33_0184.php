//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=33 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 33. 搜索旋转排序数组
 * 
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 */
class Solution {

    /**
     * 方法一：二分法
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search1($nums, $target) {
        $left = 0;
        $right = count($nums) - 1;
        while ($left <= $right) {
            $mid = $left + intval(($right - $left) / 2);
            if ($nums[$mid] == $target) return $mid;
            if ($nums[$left] <= $nums[$mid]) { //左侧有序
                if ($nums[$left] <= $target && $target < $nums[$mid]) {
                    $right = $mid - 1;
                } else {
                    $left = $mid + 1;
                }
            } else { //右侧有序
                if ($nums[$mid] < $target && $target <= $nums[$right]) {
                    $left = $mid + 1;
                } else {
                    $right = $mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 方法一：二分法(位运算)
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search($nums, $target) {
        $left = 0;
        $right = count($nums) - 1;
        while ($left <= $right) {
            $mid = $left + intval(($right - $left) / 2);
            if ($nums[$mid] == $target) return $mid;
            if (($nums[0] > $target) ^ ($nums[0] > $nums[$mid]) ^ ($target > $nums[$mid])) {
                $left = $mid + 1;
            } else {
                $right = $mid - 1;
            }
        }
        return $left == $right && $nums[$left] == $target ? $left : -1;
    }

}
// @lc code=end
