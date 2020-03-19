#
# @lc app=leetcode id=189 lang=python3
#
# [189] Rotate Array
#
from typing import List  # For linting fix of type hints

# @lc code=start


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        if length < 2:
            return
        nums[:] = nums[(length - k):] + nums[:(length - k)]
        # need further study, slice socks in space complexity :(
        # I dont have enough time this week.

# @lc code=end
