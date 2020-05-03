"""
>>> counting_sort([])
[]
>>> counting_sort([1])
[1]
>>> counting_sort([2, 1])
[1, 2]
>>> counting_sort([3, 5, 4, 1, 2, 3, 3])
[1, 2, 3, 3, 3, 4, 5]
"""
from typing import List

def counting_sort(nums: List[int]) -> List[int]:
    buckets = [0] * 20

    for num in nums:
        buckets[num] += 1

    sum = 0
    for i in range(len(buckets)):
        sum += buckets[i]
        buckets[i] = sum

    result = [0] * len(nums)
    i = len(nums) - 1
    while i >= 0:
        buckets[nums[i]] -= 1
        result[buckets[nums[i]]] = nums[i]
        i -= 1

    return result

