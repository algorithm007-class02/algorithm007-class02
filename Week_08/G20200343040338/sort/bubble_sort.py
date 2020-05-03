"""
>>> bubble_sort([])
[]
>>> bubble_sort([1])
[1]
>>> bubble_sort([2, 1])
[1, 2]
>>> bubble_sort([3, 5, 4, 1, 2])
[1, 2, 3, 4, 5]
"""
from typing import List


def bubble_sort(nums: List[int]) -> List[int]:
    for i in range(len(nums) - 1, 0, -1):
        swapped = False
        for j in range(i):
            if nums[j] > nums[j + 1]:
                swapped = True
                nums[j], nums[j + 1] = nums[j + 1], nums[j]
        if not swapped:
            break
    return nums