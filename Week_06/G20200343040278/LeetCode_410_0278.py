#
# @lc app=leetcode.cn id=410 lang=python3
#
# [410] 分割数组的最大值
#

# @lc code=start
class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        def countGroups(mid):
            temp = 0
            count = 1
            for num in nums:
                temp += num
                if temp > mid:
                    count += 1
                    temp = num
            return count
        
        left, right = max(nums), sum(nums)
        
        while left < right:
            mid = left + (right - left) // 2
            num_group = countGroups(mid)
            
            if num_group > m: 
                left = mid + 1
            else:
                right = mid
        print(left, mid, right)
        return left 

        
# @lc code=end

