class Solution:
    def canJump(self, nums) -> bool:
        if not nums:
            return False
        jump_num = len(nums) - 1
        for i in range(len(nums) - 1, -1, -1):
            if nums[i] >= jump_num - i:
                jump_num = i
        return jump_num == 0
