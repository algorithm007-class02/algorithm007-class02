class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        lenth = len(nums)
        nums[:] = nums[lenth-k:]+nums[:lenth-k]
