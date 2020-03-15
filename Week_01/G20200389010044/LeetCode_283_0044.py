# 1. 遍历，遇到0就往前挪，需要一个指针记录要插入的位置，
#   挪完非零元后把位置指针开始到数组结尾元素置为0

# 2. 双指针 - 找到零元，找到非零元，交换，直到非零元的指针遍历完数组


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 单指针 - 位置指针
        # pos = 0
        # for i in range(len(nums)):
        #     if nums[i] != 0:
        #         nums[pos] = nums[i]
        #         if i != pos:
        #             nums[i] = 0
        #         pos += 1

        # 双指针
        # size = len(nums)
        # zero = nonz = 0
        # while True:
        #     while zero < size-1 and nums[zero] != 0:
        #         zero += 1
        #     while nonz < zero or ( nonz < size and nums[nonz] == 0):
        #         nonz += 1
        #     if zero < size-1 and nonz < size:
        #         nums[zero], nums[nonz] = nums[nonz], nums[zero]
        #     else:
        #         break