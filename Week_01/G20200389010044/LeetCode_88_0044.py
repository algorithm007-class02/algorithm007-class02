# 1. 用一个新列表存储两个数组比较结果，最后再把结果倒到nums1里面

# 2. 合并后排序 - 注意不能把占位的0参与到排序中

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        # 双指针 - 从前往后 - 时间复杂度 O(n+m) 空间复杂度 O(m) 
        # temp = nums1[:m] # 暂存nums1的元素，然后将nums1作为新数组使用
        # nums1[:] = []
        # i = j = pos = 0
        # while i < m and j < n:
        #     if temp[i] < nums2[j]:
        #         nums1.append(temp[i])
        #         i += 1
        #     else:
        #         nums1.append(nums2[j])
        #         j += 1
        # if i < m:
        #     nums1 += temp[i:m]
        # if j < n:
        #     nums1 += nums2[j:n]

        # 双指针 - 空间优化 从后往前 - 时间复杂度O(m+n) 空间复杂度O(1)
        pos = m + n - 1
        i = m -1
        j = n - 1
        while i >= 0 and j >= 0:
            if nums1[i] > nums2[j]:
                nums1[pos] = nums1[i]
                pos -= 1
                i -= 1
            else:
                nums1[pos] = nums2[j]
                pos -= 1
                j -= 1
        if j >= 0:
            nums1[:pos+1] = nums2[:pos+1]

        # 合并后排序 - O((n+m)log(n+m))
        # method_1
        # nums1[:] = sorted(nums1[:m]+nums2[:n])
        # method_2
        # nums1[:] = (nums1[:m]+nums2[:n])
        # nums1.sort()

        # 空间换时间 - O(m+n)
        # lst = []
        # i = j = 0
        # while i < m and j < n:
        #     if nums1[i] < nums2[j]:
        #         lst.append(nums1[i])
        #         i += 1
        #     else:
        #         lst.append(nums2[j])
        #         j += 1
        # if i < m:
        #     lst += nums1[i:m]
        # if j < n:
        #     lst += nums2[j:n]
        # nums1[:] = lst