# -*- coding: utf-8 -*-
# @Time    : 2020-03-14 20:26 
# @Author  : peniridis
# @Version : V 0.1
# @File    : leetcode_1.py
# @Desc    :
# 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
#
#  你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
#
#  示例:
#
#  给定 nums = [2, 7, 11, 15], target = 9
#
# 因为 nums[0] + nums[1] = 2 + 7 = 9
# 所以返回 [0, 1]
#
#  Related Topics 数组 哈希表

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
            字典表存值
        :param nums:
        :param target:
        :return:
        """
        items = {}
        for i, item in enumerate(nums):
            if target - item in items:
                return [items[target - item], i]
            items[item] = i

# leetcode submit region end(Prohibit modification and deletion)
