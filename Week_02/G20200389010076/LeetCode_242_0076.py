from collections import Counter
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return Counter(s) == Counter(t)

    # def isAnagram(self, s: str, t: str) -> bool:
    #     s = Counter(s)
    #     t = Counter(t)
    #     return (s - t) == Counter() and (t - s) == Counter()