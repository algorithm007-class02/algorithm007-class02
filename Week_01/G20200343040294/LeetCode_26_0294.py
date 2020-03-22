#
# @lc app=leetcode.cn id=26 lang=python3
# @tags array | two-pointers
# [26] 删除排序数组中的重复项
#

# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        curr_idx = 0
        while curr_idx < len(nums) - 1:
            if nums[curr_idx] == nums[curr_idx + 1]:
                del nums[curr_idx]
                curr_idx -= 1
            curr_idx += 1
        return len(nums)
# @lc code=end
