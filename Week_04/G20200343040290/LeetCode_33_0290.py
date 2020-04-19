class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left,right = 0,len(nums)-1
        if len(nums) == 1 and nums[0] == target:
            return 0
        while left < right:
            mid = (left + right)//2
            if nums[mid] == target:
                return mid
            elif (target > nums[mid] or target < nums[left] and nums[mid] > nums[left]) or (nums[right] > nums[mid] and target > nums[mid] and target <nums[right]):
                left = mid+1
            else:
                right = mid
        return -1
