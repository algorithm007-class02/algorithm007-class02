/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start

// 双指针，记录不重复元素的位置
class Solution {
    public int removeDuplicates(int[] nums) {
        int nonDuplicate = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[nonDuplicate]) {
                nums[++nonDuplicate] = nums[i];
            }
        }
        return nonDuplicate + 1;
    }
}
// @lc code=end

