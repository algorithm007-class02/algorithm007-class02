#
# @lc app=leetcode.cn id=88 lang=python3
#
# [88] 合并两个有序数组
#
#
# algorithms
# Easy (46.98%)
# Likes:    444
# Dislikes: 0
# Total Accepted:    121.6K
# Total Submissions: 258.8K
# Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
#
# 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
# 
# 
# 
# 说明:
# 
# 
# 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
# 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
# 
# 
# 
# 
# 示例:
# 
# 输入:
# nums1 = [1,2,3,0,0,0], m = 3
# nums2 = [2,5,6],       n = 3
# 
# 输出: [1,2,2,3,5,6]
# 
#

# @lc code=start
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        l1=0
        l2=0
        nums_copy=nums1[:m]
        i=0
        while(l1<m and l2<n):
            if(nums_copy[l1]<nums2[l2]):
                nums1[i]=nums_copy[l1]
                l1+=1
            else:
                nums1[i]=nums2[l2]
                l2+=1
            i+=1
        if(l1<m):
            nums1[i:m+n]=nums_copy[l1:m]
        if(l2<n):
            nums1[i:m+n]=nums2[l2:n]

# @lc code=end

