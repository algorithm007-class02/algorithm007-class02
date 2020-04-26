#
# @lc app=leetcode.cn id=127 lang=python3
#
# [127] 单词接龙
#

# @lc code=start
import string
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList) -> int:
        if endWord not in wordList:
            return 0
        front={beginWord}
        back={endWord}
        dist=1
        wordList=set(wordList)
        word_len=len(beginWord)
        while front:
            dist+=1
            next_front=set()
            for word in front:
                for i in range(word_len):
                    for c in string.ascii_lowercase:
                        if c!=word[i]:
                            new_word=word[:i]+c+word[i+1:]
                            if new_word in back:
                                return dist
                            if new_word in wordList:
                                next_front.add(new_word)
                                wordList.remove(new_word)
            front=next_front
            if len(back)<len(front):
                front,back=back,front
        return 0
        
                

                    

                



# @lc code=end

if __name__ == "__main__":
    print(Solution().ladderLength("hit","cog",["hot","dot","dog","lot","log","cog"]))

# def ladderLength(self, beginWord: str, endWord: str, wordList) -> int:
#         if endWord not in wordList or not endWord or not beginWord or not wordList:
#             return 0

#         L=len(beginWord)

#         all_combo_dict=defaultdict(list)
#         for word in wordList:
#             for i in range(L):
#                 all_combo_dict[word[:i]+'*'+word[i+1:]].append(word)

#         queue=[(beginWord,1)]
#         visted={beginWord:True}
#         while queue:
#             current_word,level=queue.pop(0)
#             for i in range(L):
#                 intermediate_word=current_word[:i]+'*'+current_word[i+1:]

#                 for word in all_combo_dict[intermediate_word]:
#                     if word==endWord:
#                         return level+1
#                     if word not in visted:
#                         queue.append((word,level+1))
#                 all_combo_dict[intermediate_word]=[]
#         return 0

# def ladderLength(self, beginWord: str, endWord: str, wordList) -> int:
#         if endWord not in endWord:
#             return 0
#         length=len(beginWord)
#         dif=0
#         queue=deque()
#         queue.append(beginWord)
#         queue.append(',')
#         lay=2
#         while queue:
#             curr=queue.popleft()
#             if curr==',':
#                 lay+=1
#                 queue.append(',')
#                 continue
#             for word in wordList:
#                 for j in range(length):
#                     if curr[j]!=word[j]:
#                         dif+=1
#                     if dif>=2:
#                         dif=0
#                         break
#                 if dif==1:
#                     if word==endWord:
#                         return lay
#                     queue.append(word)
#                     dif=0
#                     wordList.remove(word)
#         return 0

# def ladderLength(self, beginWord: str, endWord: str, wordList) -> int:
#         if endWord not in endWord:
#             return 0
#         length=len(beginWord)
#         selected=[False]*len(wordList)
#         dif=0
#         queue=deque()
#         queue.append(beginWord)
#         queue.append(',')
#         lay=2
#         while queue:
#             curr=queue.popleft()
#             if curr==',':
#                 lay+=1
#                 queue.append(',')
#                 continue
#             for i in range(len(wordList)):
#                 if selected[i]:
#                     continue
#                 word=wordList[i]
#                 for j in range(length):
#                     if curr[j]!=word[j]:
#                         dif+=1
#                     if dif>=2:
#                         dif=0
#                         break
#                 if dif==1:
#                     if word==endWord:
#                         return lay
#                     selected[i]=True
#                     queue.append(word)
#                     dif=0
#         return 0