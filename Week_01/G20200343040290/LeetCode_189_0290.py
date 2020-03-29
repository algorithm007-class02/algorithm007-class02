class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        list_len = len(nums)
        nums_cp = nums[:]
        for i in range(list_len):
            stop_pos = (i+k)%list_len
            nums[stop_pos] = nums_cp[i]
