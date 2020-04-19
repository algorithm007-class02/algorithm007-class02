# 二分查找迭代法
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums == []:
            return None
        if nums[-1] >= nums[0]:
            return nums[0]

        left = 0
        right = len(nums) - 1
        while left < right:
            mid = left + (right - left) // 2
            # 如果左边为顺序，则在右边找；如果左边只有一个， 也在右边找
            if nums[0] <= nums[mid]:
                left = mid + 1
            # 否则在左边找
            else:
                right = mid

        return nums[left]