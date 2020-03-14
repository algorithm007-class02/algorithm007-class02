//<?php
/**
 * @lc app=leetcode.cn id=189 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释: 
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 
 * 链接：https://leetcode-cn.com/problems/rotate-array
 */
class Solution {

    /**
     * 方法一：暴力迭代 k * n 次，如果k > n， 可以 k = k % n 时间复杂度O(k*n) 
     * 方法二：使用临时数组，直接计算旋转到的位置
     * 方法三：直接计算元素移动到的位置
     * 方法四：三次翻转
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    function rotate(&$nums, $k) {
        //方法四
        $len = count($nums);
        $k %= $len;
        $this->reverse($nums, 0, $len - 1);
        $this->reverse($nums, 0, $k - 1);
        $this->reverse($nums, $k, $len- 1);
    }
    function reverse(&$nums, $start, $end) {
        while ($start < $end) {
            $tmp = $nums[$start];
            $nums[$start++] = $nums[$end];
            $nums[$end--] = $tmp;
        }
    }
    //方法二：使用临时数组，直接计算旋转到的位置 空间复杂度O(n) 不符合题目要求
    function rotate2(&$nums, $k) {
        $tmps = [];
        $len = count($nums);
        foreach ($nums as $index => $val) {
            $tmps[($index + $k) % $len] = $nums[$index];
        }
        foreach ($tmps as $index => $val) {
            $nums[$index] = $tmps[$index];
        }
    }
    //方法三：直接计算元素移动到的位置
    function rotate3(&$nums, $k) {
        for ($start = 0, $count = 0, $len = count($nums); $count < $len; $start++) {
            $current = $start;
            $prev = $nums[$current];
            do {
                $next = ($current + $k) % $len; //计算移动到的位置
                $tmp = $nums[$next]; //保存移动到位置的元素
                $nums[$next] = $prev;
                $current = $next;
                $prev = $tmp;
                $count++;
            } while ($start != $current);
        }
    }
}
