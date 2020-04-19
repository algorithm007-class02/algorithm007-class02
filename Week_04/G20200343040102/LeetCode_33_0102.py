#
# @lc app=leetcode.cn id=33 lang=python3
#
# [33] 搜索旋转排序数组
#
# https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
#
# algorithms
# Medium (36.46%)
# Likes:    584
# Dislikes: 0
# Total Accepted:    91.5K
# Total Submissions: 250.3K
# Testcase Example:  '[4,5,6,7,0,1,2]\n0'
#
# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
# 
# ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
# 
# 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
# 
# 你可以假设数组中不存在重复的元素。
# 
# 你的算法时间复杂度必须是 O(log n) 级别。
# 
# 示例 1:
# 
# 输入: nums = [4,5,6,7,0,1,2], target = 0
# 输出: 4
# 
# 
# 示例 2:
# 
# 输入: nums = [4,5,6,7,0,1,2], target = 3
# 输出: -1
# 
#

# @lc code=start
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low=0
        high=len(nums)-1
        if not nums:return -1
        while high-low>1:
            mid=(low+high)//2
            if nums[low]<nums[mid]:
                if target<=nums[mid] and target>=nums[low]:
                    high=mid
                else:
                    low=mid
            else:
                if target>=nums[mid] and target<=nums[high]:
                    low=mid
                else:
                    high=mid
        if nums[low]==target:return low
        if nums[high]==target:return high
        return -1
# @lc code=end

