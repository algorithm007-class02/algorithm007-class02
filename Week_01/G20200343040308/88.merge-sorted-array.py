#
# @lc app=leetcode id=88 lang=python3
#
# [88] Merge Sorted Array
#

from typing import List  # For linting fix of type hints

# @lc code=start


class Solution:
    def merge(self, nums1: List[int],
              m: int, nums2: List[int],
              n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if m == 0:
            nums1[:] = nums2
            return
        index1, index2 = -(n + 1), -1

        for index in range(1, m + n + 1):
            if index2 >= -n and \
                index1 >= -(m + n) and \
                    nums2[index2] > nums1[index1]:
                nums1[-index] = nums2[index2]
                index2 -= 1
            elif index1 >= -(m + n):
                nums1[-index], nums1[index1] = nums1[index1], nums1[-index]
                index1 -= 1
            elif index1 < -(m + n) and index2 >= -n:
                nums1[-index] = nums2[index2]
                index2 -= 1

# @lc code=end
