#
# @lc app=leetcode.cn id=120 lang=python3
#
# [120] 三角形最小路径和
#
# https://leetcode-cn.com/problems/triangle/description/
#
# algorithms
# Medium (63.88%)
# Likes:    364
# Dislikes: 0
# Total Accepted:    51.6K
# Total Submissions: 80.3K
# Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
#
# 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
# 
# 例如，给定三角形：
# 
# [
# ⁠    [2],
# ⁠   [3,4],
# ⁠  [6,5,7],
# ⁠ [4,1,8,3]
# ]
# 
# 
# 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
# 
# 说明：
# 
# 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
# 
#

# @lc code=start
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp = triangle
        for i in range(len(triangle)-2, -1, -1):
            for j in range(len(triangle[i])-1, -1, -1):
                dp[i][j] += min(dp[i+1][j], dp[i+1][j+1])
        return dp[0][0]

# 1.暴力递归
# 2.DP
#     a.分治，子问题 path(level, i) = min(path(level-1, i), path(level-1, i-1))
#     b.状态定义 f[i][j]
#     c.DP方程 dp[i][j] = min(dp[i-1][j]+, dp[i-1][j-1]) + dp[i][j]
# @lc code=end

