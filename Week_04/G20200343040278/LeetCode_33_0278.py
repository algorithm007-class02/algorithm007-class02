#
# @lc app=leetcode.cn id=33 lang=python3
#
# [33] 搜索旋转排序数组
#

# @lc code=start
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums: 
            return -1
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right)//2
            if nums[mid] == target: 
                return mid
            if nums[left] <= nums[mid]:
                if nums[left] <= target < nums[mid]: 
                    right = mid - 1
                else: left = mid + 1
            else: 
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else: right = mid - 1
        return -1


# 初见思路1：库函数
# 思路2：二分查找


# @lc code=end

