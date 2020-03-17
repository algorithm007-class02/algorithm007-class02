class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        i,j = 0,0
        count = 0
        while (i<m or j<n):
            if len(nums1)< 2*m+n:
                nums1.append(0)
            if j <n and i<m and nums1[i]>nums2[j]:
                nums1[m+count] = nums2[j]
                j += 1
            elif j <n and i<m and nums1[i]<=nums2[j]:
                nums1[m+count] = nums1[i]
                i += 1
            else:
                if i<m:
                    nums1[m+count] = nums1[i]
                    i += 1
                else:
                    nums1[m+count] = nums2[j]
                    j += 1
            count += 1
        del nums1[0:m]
