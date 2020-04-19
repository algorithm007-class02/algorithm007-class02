# 贪心法
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if nums==[]:
            return False

        i = len(nums)-1
        while i > 0:
            for j in range(i-1, -1, -1):
                if nums[j]+j >= i:
                    i = j
                    break
                else:
                    j -= 1
                    if j==-1:
                        return False
        return True