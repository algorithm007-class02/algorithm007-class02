# 1. 原地覆盖 - 位置指针 
    # 排序数组，如果元素值相等，其位置肯定相邻
    # 遍历数组，如果元素与修改后的数组末位元素相等，说明重复，则continue
    # 如果不等，则将该元素加到新数组的末尾，将位置指针指向该元素（即原pos指针+1）
    # 题目要求额外空间O(1)，则新数组与旧数组为同一数组，添加操作直接覆盖在原数组上即可
# 2. pythonic - set() + list() + sorted()
# set()函数实现去重
# list()函数重新转化为列表
# sorted()函数修正set无序的特性
# 理论上使用了额外的空间，没有显示创建新的变量，可能python会自动回收内存
# nums[:] 使得得到的结果直接存入nums所在的内存地址中，实现所谓的“原地”

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # pos = 0     # 记录位置
        # if nums:    # 数组非空
        #     count = 1
        # else:       # 数组为空
        #     count = 0
        #     return count
        # for num in nums[:]:
        #     if num == nums[pos]:  # 元素重复
        #         continue
        #     else:
        #         pos += 1
        #         nums[pos] = num
        #         count += 1
        # return count

        # pythonic
        nums[:] = sorted(list(set(nums)))