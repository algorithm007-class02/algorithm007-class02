class Solution:
    def firstUniqChar(self, s: str) -> int:
        import collections 
        cnt = collections.Counter(s)
        for i in range(len(s)):
            if cnt[s[i]] == 1:
                return i
        else:
            return -1