from collections import defaultdict as dd
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if not endWord in wordList or not endWord or not beginWord or not wordList:
            return 0

        f_dict = dd(list)
        L = len(beginWord)
        queue = []
        queue.append((beginWord,1))
        visited = set()
        for w in wordList:
            for i in range(L):
                f_dict[w[:i]+'*'+w[i+1:]].append(w)
        while queue:
            w,c = queue.pop(0)
            for i in range(L):
                word_list = f_dict[w[:i]+'*'+w[i+1:]]
                for word in word_list:
                    if word == endWord:
                        return c+1
                    elif not word in visited:
                        visited.add(word)
                        queue.append((word,c+1))
        return 0
