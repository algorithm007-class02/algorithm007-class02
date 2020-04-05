from collections import defaultdict as dd
class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        if not endWord in wordList or not endWord or not beginWord or not wordList:
            return []

        shortest_long = 0

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
                        shortest_long = c+1
                        queue = []
                        break
                    elif not word in visited:
                        visited.add(word)
                        queue.append((word,c+1))

        result = []
        def dfs(w,count,s):
            if count == shortest_long and w == endWord:
                result.append(s+[w])
                return
            if count > shortest_long:
                return

            for i in range(L):
                word_list = f_dict[w[:i]+'*'+w[i+1:]]
                for word in word_list:
                    dfs(word,count+1,s+[w])
        dfs(beginWord,1,[])
        return result
