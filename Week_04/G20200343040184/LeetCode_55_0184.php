//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=55 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 
 * 示例 2:
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * 
 * 链接：https://leetcode-cn.com/problems/jump-game
 */
class Solution {

    /**
     * 方法一：贪心法
     * @param Integer[] $nums
     * @return Boolean
     */
    function canJump($nums) {
        if (!$nums) return false;
        $revCanJump = count($nums) - 1;
        for ($i = $revCanJump; $i >= 0; $i--) {
            if ($nums[$i] + $i >= $revCanJump) {
                $revCanJump = $i;
            }
        }
        return $revCanJump == 0;
    }
}
// @lc code=end
