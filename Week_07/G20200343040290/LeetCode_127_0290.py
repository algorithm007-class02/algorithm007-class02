from collections import defaultdict as dd
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        word_len = len(beginWord)
        if not endWord in wordList or not wordList or not beginWord:
            return 0
        queue = []
        queue.append((beginWord,1))
        visited = set()
        word_dict = dd(list)
        for w in wordList:
            for c in range(word_len):
                word_dict[w[:c]+'*'+w[c+1:]].append(w)
        while queue:
            word,c = queue.pop(0)
            for i in range(word_len):
                word_cand = word[:i]+'*'+word[i+1:]
                if word_cand in word_dict:
                    for w in word_dict[word_cand]:
                        if w == endWord:
                            return c+1
                        elif not w in visited:
                            visited.add(w)
                            queue.append((w,c+1))

        return 0