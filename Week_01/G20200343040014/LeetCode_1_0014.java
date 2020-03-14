/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int sec = 0;
        for (int i = 0; i < nums.length; i++) {
            sec = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == sec){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
// @lc code=end

