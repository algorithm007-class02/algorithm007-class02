#!/usr/bin/env python

'''
https://leetcode-cn.com/problems/maximum-subarray/
53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
'''

def subMaxArray(nums):
    temp = max_ = nums[0]
    for i in range(1, len(nums)):
        if temp > 0:
            temp += nums[i]
        else:
            temp = nums[i]
        max_ = max(temp, max_)
    return max_
    

def subMaxArray02(nums):
    size = len(nums)
    if size == 0:
        return
    dp = [0 for _ in range(size)]
    for i in range(1, size):
        dp[i] = max(dp[i - 1] + nums[i], nums[i])
    return max(dp)
