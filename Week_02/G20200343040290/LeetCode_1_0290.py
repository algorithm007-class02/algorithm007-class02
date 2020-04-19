class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        len_nums = len(nums)
        hashtable = dict([(nums[i],i) for i in range(len_nums)])
        for c,i in enumerate(nums):
            if hashtable.get(target-i) and (not hashtable.get(target-i) == c):
                return [c,hashtable.get(target-i)]
        return []
