#
# @lc app=leetcode.cn id=126 lang=python3
#
# [126] 单词接龙 II
#

# @lc code=start
class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        from collections import defaultdict
        from collections import deque
        size, general_dic = len(beginWord), defaultdict(list)
        for w in wordList:
            for _ in range(size):
                general_dic[w[:_] + "*" + w[_+1:]].append(w)
        q = deque()
        q.append((beginWord, 1))
        mark_dic = defaultdict(bool)
        mark_dic[beginWord] = True
        while q:
            cur_word, level = q.popleft()
            for i in range(size):
                for neighbor in general_dic[cur_word[:i]+"*"+cur_word[i+1:]]:
                    if neighbor == endWord:
                        return level + 1
                    if not mark_dic[neighbor]:
                        mark_dic[neighbor] = True
                        q.append((neighbor, level + 1))
        return 0
# @lc code=end

