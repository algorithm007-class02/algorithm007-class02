class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        flag = 0
        for i in range(1, len(nums)):
            if nums[flag] != nums[i]:
                flag += 1
                nums[flag] = nums[i]
        return flag + 1


    def removeDuplicates02(self, nums):
        for i in range(len(nums)-1, 0, -1):
            if nums[i] == nums[i-1]:
                nums.pop(i)
        return len(nums)
