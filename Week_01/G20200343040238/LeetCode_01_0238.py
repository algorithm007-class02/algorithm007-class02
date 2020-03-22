# -*- coding:utf-8 -*-


class Solution:
    def twoSum(self, nums, target: int):
        temp_dic = {}
        for i in range(len(nums)):
            if (target - nums[i]) in temp_dic:
                return [temp_dic[target - nums[i]], i]
            else:
                temp_dic[nums[i]] = i
        return []
