#
# @lc app=leetcode.cn id=26 lang=python3
#
# [26] 删除排序数组中的重复项
#

# @lc code=start


class Solution:
    def removeDuplicates(self, nums):
        # 双指针法
        # 1、left、right=0-len(nums),left+1
        # while left<len(nums)-1 and right<len(nums)
        #   while right<len(nums) and nums[left]==nums[right]
        #       right+=1
        #   if right<len(nums):
        #       nums[left+1]=nums[right] left+1 right+1
        # return left
        left, right = 0, 1
        length = len(nums)
        while left < length - 1 and right < length:
            while right < length and nums[left] == nums[right]:
                right += 1
            if right < length:
                nums[left + 1] = nums[right]
                left += 1
                right += 1
        return left + 1
        # @lc code=end


if __name__ == "__main__":
    so = Solution()
    nums = [1, 1, 2]
    print(so.removeDuplicates(nums))