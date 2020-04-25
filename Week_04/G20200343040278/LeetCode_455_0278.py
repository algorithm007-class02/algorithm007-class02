#
# @lc app=leetcode.cn id=455 lang=python3
#
# [455] 分发饼干
#

# @lc code=start
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        cnt, i, j = 0, 0, 0
        m = len(g)
        n = len(s)
        g.sort()
        s.sort()
        while j < n and i < m:
            if s[j] >= g[i]:
                cnt += 1
                j += 1
                i += 1
            else:
                j += 1
        return cnt

      
# @lc code=end

