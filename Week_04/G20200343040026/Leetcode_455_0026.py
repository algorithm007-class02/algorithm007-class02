# 贪心解法
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        if len(g)==0 or len(s)==0:
            return 0
        g.sort()
        s.sort()
        res = 0
        while g!=[] and s!=[]:
            maxs = s.pop(-1)
            if maxs < g[0]:
                break
            i = len(g)-1
            while i >= 0:
                if g[i] <= maxs:
                    res += 1
                    g.pop(i)
                    break
                g.pop(-1)
                i -= 1
        return res
