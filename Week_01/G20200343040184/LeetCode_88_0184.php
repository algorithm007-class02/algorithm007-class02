//<?php
/**
 * @lc app=leetcode.cn id=88 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * 
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 */
class Solution {

    /**
     * 方法一：合并排序 
     * 方法二：从前往后遍历，需要临时数组存储$nums1
     * 方法三：从后往前遍历
     * @param Integer[] $nums1
     * @param Integer $m
     * @param Integer[] $nums2
     * @param Integer $n
     * @return NULL
     */
    function merge(&$nums1, $m, $nums2, $n) {
        $tail = $m + $n - 1;
        $p1 = $m - 1;
        $p2 = $n - 1;
        while ($p1 >= 0 && $p2 >= 0) {
            $nums1[$tail--] = $nums1[$p1] > $nums2[$p2] ? $nums1[$p1--] : $nums2[$p2--];
        }
        while ($p2 >= 0) {
            $nums1[$tail--] = $nums2[$p2--];
        }
    }
}