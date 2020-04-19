class Solution:
    def canJump(self, nums: List[int]) -> bool:
        most_right = len(nums) - 1
        while most_right > 0:
            find = False
            for i in range(most_right-1,-1,-1):
                if i+nums[i] >= most_right:
                    most_right = i
                    find = True
                    break
            if not find:
                return False
        return True
