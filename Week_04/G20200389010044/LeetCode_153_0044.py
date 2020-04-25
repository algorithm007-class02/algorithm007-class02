# 1. 单次遍历 - O(n)

# 2. pythonic - min

# 3. 二分查找

class Solution:
    def findMin(self, nums: List[int]) -> int:
        # 1. 手动单遍历
        # res = nums[0]
        # for num in nums:
        #     if res > num:
        #         res = num
        # return res

        # # 2. pythonic
        # return min(nums)

        # 3. 二分查找

        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            # case 1 数组半有序 mid 为升序部分后半段 - mid处的值大于left和right - 搜索右半边
            if nums[mid] > nums[left] and nums[mid] > nums[right]:
                left = mid + 1
            # case 2 数组半有序 mid 为升序部分前半段 - mid处的值小于left和right - 搜索左半边
            elif nums[mid] < nums[left] and nums[mid] < nums[right]:
                right = mid - 1
            # case 3 数组完全有序 mid处的值大于left且小于right
            elif nums[mid] >= nums[left] and nums[mid] <= nums[right]:
                right = mid - 1
        return nums[left]