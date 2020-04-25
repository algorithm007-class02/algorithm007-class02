# -*- coding: utf-8 -*-
# @Time    : 2020-03-14 20:15 
# @Author  : peniridis
# @Version : V 0.1
# @File    : leetcode_88.py
# @Desc    :
# 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
#
#
#
#  说明:
#
#
#  初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
#  你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
#
#
#
#
#  示例:
#
#  输入:
# nums1 = [1,2,3,0,0,0], m = 3
# nums2 = [2,5,6],       n = 3
#
# 输出: [1,2,2,3,5,6]
#  Related Topics 数组 双指针

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
            从后往前合并
        :param nums1: 有序数组1
        :param m: 有序数组1长度
        :param nums2: 有序数组2
        :param n: 有序数据2长度
        :return: None
        """
        p = m + n - 1
        p1 = m - 1
        p2 = n - 1
        while p1 >= 0 and p2 >= 0:
            if nums1[p1] < nums2[p2]:
                nums1[p], p2, p = nums2[p2], p2 - 1, p - 1
            else:
                nums1[p], p1, p = nums1[p1], p1 - 1, p - 1
        nums1[:p2 + 1] = nums2[:p2 + 1]
