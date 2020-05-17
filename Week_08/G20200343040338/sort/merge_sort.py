"""
# >>> merge_sort([])
# []
# >>> merge_sort([1])
# [1]
>>> merge_sort([2, 1])
[1, 2]
>>> merge_sort([3, 5, 4, 1, 2])
[1, 2, 3, 4, 5]
"""
from typing import List


def merge_sort(nums: List[int]) -> List[int]:
    def _merge_sort(nums, low, high):
        if low >= high:
            return

        mid = (low + high) // 2

        _merge_sort(nums, low, mid)
        _merge_sort(nums, mid + 1, high)

        _merge(nums, low, mid, high)

    def _merge(nums, low, mid, high):
        merged = []
        i, j = low, mid + 1

        while i <= mid and j <= high:
            if nums[i] <= nums[j]:
                merged.append(nums[i])
                i += 1
            else:
                merged.append(nums[j])
                j += 1

        while i <= mid:
            merged.append(nums[i])
            i += 1

        while j <= high:
            merged.append(nums[j])
            j += 1

        for i, num in enumerate(merged):
            nums[low + i] = num

    _merge_sort(nums, 0, len(nums) - 1)

    return nums
