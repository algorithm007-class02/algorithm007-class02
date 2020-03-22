class Solution:
    @staticmethod
    def remove_duplicates(nums):
        #  利用双指针法
        #  根据题意,给的是排序后数组,所以我默认它非空,空判断在下面注释
        #  if len(nums) == 0 :
        #  return 0
        x = 1
        for i in range(len(nums) - 1):
            #  i指针对比相邻两个值的是否相同,不同则将x指针的值改成不相同的值并将x指针后移
            if nums[i] != nums[i + 1]:
                nums[x] = nums[i + 1]
                x += 1
