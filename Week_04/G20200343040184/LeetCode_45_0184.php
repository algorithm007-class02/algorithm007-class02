//<?php
/**
 * 上面的注释是为了直接提交leetcode
 * @lc app=leetcode.cn id=45 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 */
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function jump($nums) {
        if (count($nums) < 2) return 0; 
        $jump_nim = 1;
        $pre_max_index = $curr_max_index = $nums[0];
        foreach ($nums as $index => $num) {//可以改为for 循环
            if($index == 0) continue;
            if ($index > $curr_max_index) {
                $jump_nim++;
                $curr_max_index = $pre_max_index;
            }
            //计算并保存最远可以跳到位置
            if ($pre_max_index < $num + $index) {
                $pre_max_index = $num + $index;
            }
        }
        return $jump_nim;
    }
}
// @lc code=end
