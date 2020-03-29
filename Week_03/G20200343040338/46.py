from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 0:
            return [[]]

        return [[num] + x
                for num in nums
                for x in self.permute([y for y in nums if y != num])]
