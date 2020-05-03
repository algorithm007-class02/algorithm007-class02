"""
>>> selection_sort([])
[]
>>> selection_sort([1])
[1]
>>> selection_sort([2, 1])
[1, 2]
>>> selection_sort([3, 5, 4, 1, 2])
[1, 2, 3, 4, 5]
"""
from typing import List


def selection_sort(nums: List[int]) -> List[int]:
    for i in range(len(nums) - 1):
        min = i
        for j in range(i + 1, len(nums)):
            if nums[j] < nums[min]:
                min = j
        nums[i], nums[min] = nums[min], nums[i]
    return nums


