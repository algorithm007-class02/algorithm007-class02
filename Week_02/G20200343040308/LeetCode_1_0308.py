#
# @lc app=leetcode id=1 lang=python3
#
# [1] Two Sum
#
from typing import List

# @lc code=start


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        index_dict = {}
        for index in range(0, len(nums)):
            num = nums[index]
            if num not in index_dict:
                # if same value exists twice, for the assumption
                # that we only have one solution, we don't lose
                # usefuly information if we only save first position
                # of duplicated num in nums position
                index_dict[num] = index
            if (target - num) in index_dict:
                if not index_dict[target - num] == index:
                    return index_dict[target - num], index

# @lc code=end
