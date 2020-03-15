#
# @lc app=leetcode id=283 lang=python3
#
# [283] Move Zeroes
#

# @lc code=start
from typing import List  # For linting fix of type hints


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        front, back = -1, -1
        for num in nums:
            front = front + 1
            if num != 0:
                back = back + 1
                if front != back:
                    nums[back] = num
                    nums[front] = 0


# @lc code=end
