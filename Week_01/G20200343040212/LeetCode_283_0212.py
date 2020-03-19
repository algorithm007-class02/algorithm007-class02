# -*- coding: utf-8 -*-
# @Time    : 2020-03-12 21:52 
# @Author  : peniridis
# @Version : V0.1
# @File    : leetcode_283.py
# @Desc    :
# 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
#
#  示例:
#
#  输入: [0,1,0,3,12]
# 输出: [1,3,12,0,0]
#
#  说明:
#
#
#  必须在原数组上操作，不能拷贝额外的数组。
#  尽量减少操作次数。
#
#  Related Topics 数组 双指针

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        zeros = 0
        for index in range(len(nums)):
            if nums[index] == 0:
                zeros += 1
            else:
                nums[index], nums[index - zeros] = nums[index - zeros], nums[index]

# leetcode submit region end(Prohibit modification and deletion)
