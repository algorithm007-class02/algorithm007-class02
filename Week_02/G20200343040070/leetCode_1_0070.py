class Solution:
    @staticmethod
    def two_sum(nums, target):
        num_list = {}
        # 遍历数组,如果target与val的差值在num_list中,返回值对应的下标
        # 如果不在则将val作为key,存入下标
        for index, val in enumerate(nums):
            if target - val in num_list:
                return num_list[target - val], index
            num_list[val] = index
