"""
>>> quick_sort([])
[]
>>> quick_sort([1])
[1]
>>> quick_sort([2, 1])
[1, 2]
>>> quick_sort([3, 5, 4, 1, 2])
[1, 2, 3, 4, 5]
"""
from typing import List


def quick_sort(nums: List[int]) -> List[int]:
    def _quick_sort(nums, low, high):
        if low >= high:
            return

        p = _partition(nums, low, high)

        _quick_sort(nums, low, p - 1)
        _quick_sort(nums, p + 1, high)

    def _partition(nums, low, high):
        pivot = nums[high]
        p = low

        for i in range(low, high):
            if nums[i] < pivot:
                if i != p:
                    nums[i], nums[p] = nums[p], nums[i]
                p += 1

        nums[p], nums[high] = nums[high], nums[p]

        return p

    _quick_sort(nums, 0, len(nums) - 1)
    return nums
