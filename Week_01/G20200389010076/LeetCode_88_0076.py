#
# @lc app=leetcode.cn id=88 lang=python3
#
# [88] 合并两个有序数组
#

# @lc code=start
class Solution:
    def merge(self, nums1, m, nums2, n):
        """
        Do not return anything, modify nums1 in-place instead.
        """
        insert=m+n-1
        m=m-1
        n=n-1
        while n>=0 and m>=0:
            if nums1[m]<=nums2[n]:
                nums1[insert]=nums2[n]
                n-=1
            else:
                nums1[insert]=nums1[m]
                m-=1
            insert-=1
        if n>=0:
            nums1[insert-n:insert+1]=nums2[0:n+1]
        return nums1
# @lc code=end


if __name__ == "__main__":
    so=Solution()
    nums1 = [0]
    m = 0
    nums2 = [1]
    n = 1
    print(so.merge(nums1,m,nums2,n))
