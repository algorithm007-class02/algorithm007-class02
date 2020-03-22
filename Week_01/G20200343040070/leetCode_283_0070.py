class Solution:
    @staticmethod
    def move_zeroes(nums):
        # 根据题意,我默认它是一个非空数组,并且长度最小是2
        # 统计数组中0有多少个,nums[:]是在原始数组上进行改动,并非开辟新的空间
        # 将所有非零数字填入,之后补0
        count = nums.count(0)
        nums[:] = [i for i in nums if i != 0]
        nums += [0]*count
