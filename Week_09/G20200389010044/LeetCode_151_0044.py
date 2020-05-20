class Solution:
    def reverseWords(self, s: str) -> str:
        # return " ".join(reversed(s.strip().split()))

        # left, right = 0, len(s) - 1
        # # 去掉字符串开头的空白字符
        # while left <= right and s[left] == ' ':
        #     left += 1
        
        # # 去掉字符串末尾的空白字符
        # while left <= right and s[right] == ' ':
        #     right -= 1
            
        # d, word = collections.deque(), []
        # # 将单词 push 到队列的头部
        # while left <= right:
        #     if s[left] == ' ' and word:
        #         d.appendleft(''.join(word))
        #         word = []
        #     elif s[left] != ' ':
        #         word.append(s[left])
        #     left += 1
        # d.appendleft(''.join(word))
        
        # return ' '.join(d)

        # iterate the str in a reversed order
        # trim the trailing space
        # if we encountered a " " before the worlds, we know a word ended here
        # append " " or the word
        new_string = ""
        wend= len(s)
        for wstart in range(len(s)-1,-1,-1):
            if s[wstart] == " ":
                wend = wstart
            elif wstart == 0 or s[wstart-1] == " ":
                if len(new_string) != 0:
                    new_string += " "
                new_string += s[wstart:wend]
        return new_string