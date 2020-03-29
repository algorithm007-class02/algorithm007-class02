from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs):
        dfdict=defaultdict(list)
        for x in strs:
            dfdict[tuple(sorted(x))].append(x)
        return list(dfdict.values())