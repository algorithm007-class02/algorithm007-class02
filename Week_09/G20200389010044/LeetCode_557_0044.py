class Solution:
    def reverseWords(self, s: str) -> str:
        words = s.split()
        res = []
        for word in words:
            res.append(''.join(reversed(word)))
        return ' '.join(res)