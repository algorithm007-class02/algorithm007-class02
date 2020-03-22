# 暴力迭代
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums)<=1:
            return []

        for i in range(len(nums)-1):
            for j in range(i+1,len(nums)):
                if nums[i]+nums[j]==target:
                    return [i,j]
        return

# 字典
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums) <= 1:
            return []

        tmp_dic = {}
        for i, num in enumerate(nums):
            res = target - nums[i]
            if res in tmp_dic:
                return [tmp_dic[res], i]
            else:
                tmp_dic[num] = i

        return