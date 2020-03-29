#
# @lc app=leetcode.cn id=283 lang=python3
#
# [283] 移动零
#
#
# 双指针思路
# 1. 设置一个slow代表慢指针。
# 2. 用快指针遍历nums。
# 3. 当快指针找到一个非0数后，交换快慢指针的数。

# @lc code=start
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        slow = 0
        for fast in range(len(nums)):
            if nums[fast] != 0:
                nums[slow], nums[fast] = nums[fast], nums[slow]
                slow += 1
# @lc code=end

