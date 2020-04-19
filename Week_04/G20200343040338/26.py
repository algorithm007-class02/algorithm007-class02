"""https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
>>> s = Solution()
>>> s.removeDuplicates([0,0,1,1,1,2,2,3,3,4])
5
>>> s.removeDuplicates([1,2])
2
"""
from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = -1

        for j in range(0, len(nums)):
            if j == 0 or nums[j] != nums[i]:
                i += 1
                if i != j:
                    nums[j], nums[i] = nums[i], nums[j]

        while len(nums) > i + 1:
            nums.pop()

        return i + 1
