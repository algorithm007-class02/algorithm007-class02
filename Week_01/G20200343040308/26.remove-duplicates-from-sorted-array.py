#
# @lc app=leetcode id=26 lang=python3
#
# [26] Remove Duplicates from Sorted Array
#

from typing import List  # For linting fix of type hints
# Put to be deleted between slow and fast points
# then when fast reached the end of the list, to del
# seqential tail slice from list in one go is
# constantly in time complexity, which avoided
# pop/ remove in each epic in forloop, where it's O(n).

# @lc code=start


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        length = len(nums)
        if length < 2:
            return length
        slow = 0
        for fast in range(1, length):
            if nums[fast] != nums[slow]:
                slow += 1
                if slow < fast:
                    nums[slow], nums[fast] = nums[fast], nums[slow]
        if slow < length:
            del nums[slow + 1:]
        return length - (fast - slow)
# @lc code=end
