#
# @lc app=leetcode.cn id=264 lang=python3
#
# [264] 丑数 II
#

# @lc code=start
import heapq
class Ugly:
    def __init__(self):
        seen={1,}
        self.nums=nums=[]
        heap=[]
        heapq.heappush(heap,1)

        for i in range(1690):
            curr_ugly=heapq.heappop(heap)
            nums.append(curr_ugly)
            for j in [2,3,5]:
                new_ugly=curr_ugly*j
                if new_ugly not in seen:
                    seen.add(new_ugly)
                    heapq.heappush(heap,new_ugly)
class Solution:
    u=Ugly()
    def nthUglyNumber(self, n: int) -> int:
        return self.u.nums[n-1]
        
# @lc code=end

