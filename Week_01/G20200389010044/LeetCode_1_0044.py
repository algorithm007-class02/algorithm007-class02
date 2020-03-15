# 1. 暴力法

# 2. 排序去重后双指针收敛
#       要返回原数组的下标，所以必须保留原数组不改动
#       输出唯一，找到符合条件的值即可直接返回



class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 排序
        nums_sorted = sorted(nums)
        # 假设给定的nums已经是有序的
        low, high = 0, len(nums)-1
        res = []
        while low < high:   # 不能重复利用数组中同样的元素，所以取等时即可结束循环
            numSum = nums_sorted[low] + nums_sorted[high]
            if numSum > target:
                high -= 1
            elif numSum < target:
                low += 1
            else:
                if nums_sorted[low] == nums_sorted[high]:
                    # 由值找下标的index()方法只能找到第一次出现的下标
                    # 逆向思维，遍历下标匹配值
                    temp = [i for i in range(len(nums)) if nums[i] == nums_sorted[high]]
                    res += temp[:2]
                else:
                    res.append(nums.index(nums_sorted[low]))
                    res.append(nums.index(nums_sorted[high]))
                break
        return sorted(res)