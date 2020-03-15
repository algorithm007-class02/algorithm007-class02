#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    def twoSum (self,nums,target):
        n=len(nums)
        for i in range(n):
            for j in range(i+1,n):
                if nums[i]+nums[j]==target:
                    return i,j
                    break
                else:
                    continue
            




# @lc code=end

