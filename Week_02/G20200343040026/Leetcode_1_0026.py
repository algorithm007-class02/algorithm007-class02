# 哈希法
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums)<2:
            return []
        hash_map = dict()
        for i,num in enumerate(nums):
            if target-num in hash_map:
                return [hash_map[target-num],i]
            if num not in hash_map:
                hash_map[num] = i
        return []