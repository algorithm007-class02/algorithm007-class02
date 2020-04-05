#
# @lc app=leetcode.cn id=45 lang=python3
#
# [45] 跳跃游戏 II
#

# @lc code=start
class Solution:
    def jump(self, nums: List[int]) -> int:
        cnt = 0
        loc = 0
        steps = 0
        n = len(nums)
        while loc < n - 1:
            CanJump = 0
            now = loc
            if nums[loc] >= n - loc - 1:
                steps += 1
                break
            for i in range(1, nums[loc] + 1):
                if nums[now + i] + i > CanJump:
                    CanJump = nums[now + i] + i
                    loc = i + now
            steps += 1
        return steps


# 初见思路1：
# 正序贪心
# @lc code=end

