#
# @lc app=leetcode.cn id=283 lang=python3
#
# [283] 移动零
#

# @lc code=start
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if nums == []:
            return 
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i], nums[j] = nums[j], nums[i]
                j += 1


# 初见思路1：
# 双指针法：i定位非0元素，j定位0元素
# j同时等于遍历中记录的非零元素个数，所以初始值为0即可 


# @lc code=end

