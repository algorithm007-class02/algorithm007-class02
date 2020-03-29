# 解法1：遍历
class Solution1:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]

# 解法2：使用字典（两遍字典法）
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {num: idx for idx, num in enumerate(nums)}

        for idx, num in enumerate(nums):
            complement = target - num

            if complemnt in map and map[complement] != idx:
                return [idx, map[complement]]


# 解法3：一遍字典法
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}

        for idx, num in enumerate(nums):
            complement = target - num

            if complement in map:
                return [idx, map[complement]]

            map[num] = idx
