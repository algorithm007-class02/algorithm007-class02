#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for i, value in enumerate(nums):
            diff = target - value
            if diff in hashmap:
                return [hashmap.get(diff), i]
            hashmap[value] = i


# 初见思路1：
# O(n^2)

# 初见思路2：
# 字典(≈哈希表)
# 考虑相等和不相等情况
# 第一次写的代码
'''
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict_nums = {}
        for i in range(len(nums)):
            if(dict_nums.get(nums[i])) == None:
                dict_nums[nums[i]] = []
            dict_nums[nums[i]].append(i) 
        for num in nums:
            if dict_nums.get(target - num) != None:
                # 相等情况
                if num == target - num and not len(dict_nums[num]) == 1:
                    return [dict_nums[num][0], dict_nums[num][1]]
                # 不相等情况
                elif num != target - num:
                    return [dict_nums[num][0], dict_nums[target - num][0]] 

'''

# 题解——哈希表：
# 思路相同，但不需要考虑重复元素问题，代码较为简洁 


# @lc code=end

