#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    # 时间复杂度O（n）
    # 空间复杂度O（n）
    def twoSum(self, nums, target) :
        length=len(nums)
        store_dict={}
        for i in range(length):
            finded=store_dict.get(target-nums[i])
            if finded!=None:
                return [finded,i]
            store_dict[nums[i]]=i
        return []
# @lc code=end


if __name__ == "__main__":
    so = Solution()
    nums = [2, 7, 11, 15]
    target = 17
    print(so.twoSum(nums, target))
