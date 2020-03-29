#
# @lc app=leetcode.cn id=283 lang=python3
#
# [283] 移动零
#

# @lc code=start
class Solution:
    def moveZeroes(self, nums):
        """
        Do not return anything, modify nums in-place instead.
        """
        move_zero = 0

        for move_ele in range(0, len(nums)):
            if nums[move_ele]:
                nums[move_zero], nums[move_ele] = nums[move_ele], nums[move_zero]
                move_zero += 1
        return nums


# @lc code=end


if __name__ == "__main__":
    so = Solution()
    nums = [0, 1, 0, 3, 12]
    print(so.moveZeroes(nums))

# def moveZeroes(self, nums):
#             """
#             Do not return anything, modify nums in-place instead.
#             """
#             length=len(nums)
#             move_zero=0
#             while move_zero<length:
#                 if nums[move_zero]:
#                     break
#                 move_zero+=1

#             start=move_zero+1
#             for move_ele in range(start,length):
#                 if nums[move_ele]:
#                     nums[move_zero]=nums[move_ele]
#                     move_zero+=1
#             for i in range(move_zero,length):
#                 nums[i]=0
#             return

# def moveZeroes(self, nums):
#         """
#         Do not return anything, modify nums in-place instead.
#         """
#         for i in nums:
#             if i==0:
#                 nums.remove(i)
#                 nums.append(0)