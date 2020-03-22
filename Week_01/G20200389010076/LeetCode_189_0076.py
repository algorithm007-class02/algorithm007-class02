#
# @lc app=leetcode.cn id=189 lang=python3
#
# [189] 旋转数组
#

# @lc code=start
class Solution:
    def rotate(self, nums, k):
        """
        Do not return anything, modify nums in-place instead.
        """
        length=len(nums)
        nums[:]=nums[length-k:length]+nums[0:length-k]
        return nums

# @lc code=end

if __name__ == "__main__":
    so=Solution()
    nums=[1,2,3,4,5,6,7]
    k=3
    print(so.rotate(nums,k))


