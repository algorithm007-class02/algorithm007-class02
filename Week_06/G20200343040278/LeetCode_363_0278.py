#
# @lc app=leetcode.cn id=363 lang=python3
#
# [363] 矩形区域不超过 K 的最大数值和
#

# @lc code=start

class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        import bisect
        def maxSubArray(self, nums, k):
            cur_sum, max_sum = 0, float('-inf')
            sums = [0]
            for i, n in enumerate(nums, 1):
                cur_sum += n
                idx = bisect.bisect_left(sums, cur_sum - k)
                if idx != i:
                    max_sum = max(max_sum, cur_sum - sums[idx])
                bisect.insort(sums, cur_sum)
            return max_sum
        n_row, n_col = len(matrix), len(matrix[0])
        ans = float('-inf')
        for l in range(n_col):
            sums = [0] * n_row
            for r in range(l, n_col):
                for i in range(n_row):
                    sums[i] += matrix[i][r]
                ans = max(ans, self.maxSubArray(sums, k))
        return ans
                        

        
# @lc code=end

