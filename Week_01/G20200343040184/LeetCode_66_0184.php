<?php
/**
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 链接：https://leetcode-cn.com/problems/plus-one
 */
class Solution {

    /**
     * @param Integer[] $digits
     * @return Integer[]
     */
    function plusOne($digits) {
        //判断参数是否合法
        if (empty($digits)) return $digits;
        //从后往前遍历
        for ($index = count($digits) - 1; $index >=0; $index--) {
            $digits[$index] = ($digits[$index] + 1) % 10;
            //如果加等于零需要进1，不等于0退出遍历
            if ($digits[$index] != 0) {
                return $digits;
            }
        }
        //遍历结束，最高位为0，需要进1操作
        array_unshift($digits, 1);
        return $digits;
    }
}