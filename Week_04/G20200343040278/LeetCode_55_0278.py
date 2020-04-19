#
# @lc app=leetcode.cn id=55 lang=python3
#
# [55] 跳跃游戏
#

# @lc code=start
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums:
            return False
        n = len(nums)
        endReachable = n - 1
        for i in range(n - 1, -1, -1):
            if nums[i] + i >= endReachable:
                endReachable = i
        return endReachable == 0
        
# 初见思路1：递归
# 从后往前数，递归到列表长度为1
# 但是超时了
# 改写代码，不使用列表进行递归而是直接传递index 

# @lc code=end

