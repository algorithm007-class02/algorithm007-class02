# 二分查找一趟递归法
class Solution:
    def search(self, nums: List[int], target: int) -> int:

        if nums==[]:
            return -1
        if len(nums)==1:
            return -1 if nums[0]!=target else 0

        mid = len(nums) // 2

        if nums[mid]==target:
            return mid

        if nums[0]<=target<=nums[mid-1]:
            res = self.search(nums[:mid], target)
            return res
        elif target>=nums[0]>nums[mid-1] or target<=nums[mid-1]<nums[0]:
            res = self.search(nums[:mid], target)
            return res
        else:
            res = self.search(nums[mid:], target)
            return mid+res if res!=-1 else -1

