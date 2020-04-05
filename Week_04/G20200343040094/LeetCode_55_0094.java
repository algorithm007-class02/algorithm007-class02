/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++){
            if(i > maxLen) return false;
            maxLen = Math.max(maxLen, nums[i] + i);
            if(maxLen >= nums.length-1) break;
        }
        return true;
    }
}
// @lc code=end

