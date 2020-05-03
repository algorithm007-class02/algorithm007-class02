"""
>>> insertion_sort([])
[]
>>> insertion_sort([1])
[1]
>>> insertion_sort([2, 1])
[1, 2]
>>> insertion_sort([3, 5, 4, 1, 2])
[1, 2, 3, 4, 5]
"""
from typing import List


def insertion_sort(nums: List[int]) -> List[int]:
    for i in range(1, len(nums)):
        num = nums[i]
        j = i - 1
        while j >= 0:
            if nums[j] > num:
                nums[j + 1] = nums[j]
                j -= 1
            else:
                break
        nums[j + 1] = num
    return nums
