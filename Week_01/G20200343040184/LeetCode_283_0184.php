//<?php
/**
 * @lc app=leetcode.cn id=283 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 1.必须在原数组上操作，不能拷贝额外的数组。
 * 2.尽量减少操作次数。
 * 
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 
 */
class Solution {

    /**
     * 双指针法
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes(&$nums) {
        for ($i = 0, $j = 0, $len = count($nums); $i < $len; $i++) {
            if ($nums[$i] != 0) {
                //这里也可以写成交换
                if ($i != $j) {
                    $nums[$j] = $nums[$i];
                    $nums[$i] = 0;
                }
                $j++;
            }
        }
    }

    //第二种写法
    function moveZeroes1(&$nums) {
        $lastnonzerofoundat = 0; 
        $len = count($nums);//不在迭代中重复执行count
        for ($i = 0; $i < $len; $i++) {
            if ($nums[$i] != 0) {
                $nums[$lastnonzerofoundat++] = $nums[$i];
            }
        }
        for ($i = $lastnonzerofoundat; $i < $len; $i++){
            $nums[$i] = 0;
        }
    }

}
