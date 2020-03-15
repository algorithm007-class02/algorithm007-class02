#
# @lc app=leetcode.cn id=26 lang=python3
#
# [26] 删除排序数组中的重复项
#

# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0    
        mark = nums[0]
        i = 1
        while i < len(nums):
            if nums[i] == mark:
                nums.pop(i)
            else:
                mark = nums[i]
                i += 1
        return len(nums)

# 初次思路：
# 1、首先标记第一个元素的位置；
# 2、遍历一次列表，遇到重复元素则pop()，遇到非重复元素标记；
# 3、注意pop()后列表长度-1，应注意index位置。

# 题解思路1——pythonic解法：
#       nums[:] = sorted(list(set(nums)))
# 1、set()去重
# 2、列表化并排序
# 此解法是否使用了额外的内存空间？否，理论上使用了额外的空间，没有显示创建新的变量，可能python会自动回收内存
# nums[:] 使得得到的结果直接存入nums所在的内存地址中，实现所谓的“原地”


# @lc code=end

