"""
两数之和
""" 
#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
# 1. 使用哈希表，遍历nums
# 2. if target - num not in hashmap --> hashmap[num] = index


# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
    # def twoSum(self, nums, target):
        hashmap = {}
        for index, num in enumerate(nums): 
            if target - num in hashmap:
                return [hashmap[target - num], index]
            else:
                hashmap[num] = index
            print(hashmap)

# @lc code=end