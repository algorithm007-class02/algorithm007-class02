#
# @lc app=leetcode.cn id=42 lang=python3
#
# [42] 接雨水
#
# https://leetcode-cn.com/problems/trapping-rain-water/description/
#
# algorithms
# Hard (49.26%)
# Likes:    946
# Dislikes: 0
# Total Accepted:    65K
# Total Submissions: 131.2K
# Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
#
# 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
# 
# 
# 
# 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
# Marcos 贡献此图。
# 
# 示例:
# 
# 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
# 输出: 6
# 
#

# @lc code=start
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height: return 0   ## easy to forget
        n = len(height)
        i,j = 0, n - 1  
        maxleft,maxright = height[0],height[n - 1]
        ans = 0
        while i <= j:
            maxleft = max(height[i],maxleft)
            maxright = max(height[j],maxright)
            if maxleft < maxright:
                ans += maxleft - height[i]
                i += 1
            else:
                ans += maxright - height[j]
                j -= 1

        return ans

# @lc code=end

