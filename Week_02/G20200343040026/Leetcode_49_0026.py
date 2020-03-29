## 哈希表异位词判断

from collections import Counter

class Solution:
    def __init__(self):
        self.cnt = Counter

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        if len(strs) == 0:
            return []
        dic = dict()
        for word in strs:
            key, boo = self.match(word, dic)
            if boo:
                dic[key].append(word)
            else:
                dic[word] = [word]
        res = []
        for value in dic.values():
            res.append(value)
        return res

    def match(self, word, dic):
        for key in dic:
            if self.cnt(word) == self.cnt(key):
                return key, True
            else:
                pass
        return None, False

# 数字指纹法
from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dic = defaultdict(list)
        for word in strs:
            count = [0]*26
            for char in word:
                count[ord(char)-ord('a')]+=1
            dic[tuple(count)].append(word)
        return list(dic.values())