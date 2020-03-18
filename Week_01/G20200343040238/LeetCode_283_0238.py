# -*- coding:utf-8 -*-


class Solution:
    def moveZeroes(self, nums) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0 and nums[j] == 0 and i != j:
                nums[i], nums[j] = nums[j], nums[i]
                j += 1
            elif nums[i] == 0 and nums[j] != 0:
                j += 1
