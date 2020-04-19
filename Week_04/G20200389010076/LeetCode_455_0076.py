class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()

        i,j=0,0
        res=0
        len_g=len(g)
        len_s=len(s)
        while i<len_g and j<len_s:
            if g[i]<=s[j]:
                i+=1
                j+=1
                res+=1
            else:
                j+=1
        return res