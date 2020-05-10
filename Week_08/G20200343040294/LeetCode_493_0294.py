#
# @lc app=leetcode.cn id=493 lang=python
#
# [493] 翻转对
#

# @lc code=start
class Solution(object):
    def __init__(self):
        self.cnt = 0
    def reversePairs(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        def msort(lst):
            # merge sort body
            L = len(lst)
            if L <= 1: # base case
                return lst
            else: # recursive case
                return merger(msort(lst[:int(L/2)]), msort(lst[int(L/2):]))
            
        def merger(left, right):
            # merger
            l, r = 0, 0 # increase l and r iteratively
            while l < len(left) and r < len(right):
                if left[l] <= 2*right[r]:
                    l += 1
                else:
                    self.cnt += len(left)-l # add here
                    r += 1
            return sorted(left+right)# I can't avoid TLE without timsort...

        msort(nums)
        return self.cnt
        
# @lc code=end

