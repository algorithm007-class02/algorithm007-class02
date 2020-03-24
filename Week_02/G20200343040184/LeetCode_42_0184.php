//<?php
/**
 * @lc app=leetcode.cn id=42 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water/
 */
class Solution {

    /**
     * 方法一：栈(栈顶元素比当前元素小，计算雨水并累加)
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param Integer[] $heights
     * @return Integer
     */
    function trap1($heights) {
        $ans = 0;
        $stack = [];//数组模拟栈
        $count = count($heights);
        for ($i = 0; $i < $count; $i++) {
            while ($stack && $heights[end($stack)] < $heights[$i]) {
                $top = array_pop($stack);
                if (!$stack) break;
                $width = $i - end($stack) - 1;
                $height = min($heights[end($stack)], $heights[$i]) - $heights[$top];
                $ans += $width * $height;
            }
            $stack[] = $i;
        }
        return $ans;
    }
    /**
     * 方法二：双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param Integer[] $heights
     * @return Integer
     */
    function trap($heights) {
        $ans = 0;
        $left = 0;
        $right = count($heights) - 1;
        $level = 0;
        while ($left < $right) {
            $lowar = $heights[$heights[$left] < $heights[$right] ? $left++ : $right--];
            $level = max($level, $lowar);
            $ans += $level - $lowar;
        }
        return $ans;
    }
}
// @lc code=end