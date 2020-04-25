# BFS
from collections import deque, defaultdict
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if wordList == [] or endWord not in wordList:
            return 0

        length = len(beginWord)
        process_dic = defaultdict(list)
        for word in wordList:
            for i in range(length):
                process_dic[word[:i] + '*' + word[i + 1:]].append(word)

        queue = deque()
        queue.append((beginWord, 1))
        visited = set(beginWord)

        while queue:
            cur, level = queue.popleft()
            visited.add(cur)
            for i in range(length):
                tmp_cur = cur[:i] + '*' + cur[i + 1:]
                for word in process_dic[tmp_cur]:
                    if word == endWord:
                        return level + 1
                    if word not in visited:
                        queue.append((word, level + 1))
        return 0