<?php
/**
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 
 */
class Solution {

    /**
     * hash表方式
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        //验证非法数据
        if (count($nums) < 2) return []; 
        $hash = [];
        for ($i = 0; $i < count($nums); $i++) {
            $sub = $target - $nums[$i];
            if (isset($hash[$sub])) {
                return [$hash[$sub], $i];
            }
            $hash[$nums[$i]] = $i;
        }
        return [];
    }

    /**
     * 暴力两层循环
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum1 ($nums, $target) {
        $len = count($nums);
        for ($i = 0; $i < $len - 1; $i++) {
            for ($j = $i + 1; $j < $len; $j++) {
                //判断是否符合题解
                if ($nums[$i] + $nums[$j] == $target){
                    return [$i, $j]; 
                }
            }
        }
        return [];
    }
}