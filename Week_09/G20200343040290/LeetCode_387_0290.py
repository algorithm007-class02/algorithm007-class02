class Solution:
    def firstUniqChar(self, s: str) -> int:
        dicts={}
        for i in s:
            dicts[i]=dicts.get(i,0)+1
        for i in range(len(s)):
            if dicts[s[i]]==1:
                return i
        return -1