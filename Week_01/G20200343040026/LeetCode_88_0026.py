#迭代法
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if nums2 == []:
            return
        i,j,k = m-1,n-1,-1
        while i>=0 and j>=0:
            if nums1[i]>nums2[j]:
                nums1[k] = nums1[i]
                i-=1
            else:
                nums1[k] = nums2[j]
                j-=1
            k-=1
        while j>=0:
            nums1[k] = nums2[j]
            j-=1
            k-=1