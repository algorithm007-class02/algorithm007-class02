class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        no_zero_count = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[no_zero_count],nums[i] = nums[i],nums[no_zero_count]
                no_zero_count += 1
