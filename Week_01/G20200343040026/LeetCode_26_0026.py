# 解法一:单变量储存解法
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums)<=1:
            return

        tmp = float('inf')
        i = 0
        while i<len(nums):
            if nums[i] == tmp:
                nums.pop(i)
            else:
                tmp = nums[i]
                i += 1

# 解法二:双指针解法
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums)<=1:
            return
        i = 0
        j = 1
        while i<j<len(nums):
            if nums[i]!=nums[j]:
                i+=1
                nums[i] = nums[j]
            j+=1

        return i+1
