#
# @lc app=leetcode.cn id=88 lang=python3
#
# [88] 合并两个有序数组
#

# @lc code=start
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        assert m + n == len(nums1)
        j = 0
        temp = m  # 0的位置
        for i in range(n):
            while nums2[i] > nums1[j] and j < temp:
                j += 1
            # B没进完的情况
            if j == temp:
                while len(nums1) != temp:
                    nums1.pop()
                nums1.extend(nums2[i:])
                break
            else:
                nums1.insert(j, nums2[i])
                nums1.pop()
                j += 1
                temp += 1


# 初次思路1:
# 设置两个指针i，j分别指向nums2和nums1，其中i表示遍历nums2中元素index，j表示nums1中插入位置，进行比较
# 其中每进一个nums2的元素就会pop一个nums1的0，所以不存在nums2的元素都进入nums1后还有剩余0的情况
# 故仅考虑nums2没进完的情况，即nums2的剩余元素均大于nums1中非零的最后一个元素


# @lc code=end

