#
# @lc app=leetcode.cn id=8 lang=python3
#
# [8] 字符串转换整数 (atoi)
#

# @lc code=start
INI_MAX=2**31-1
INT_MIN=-2**31

class Automaton:
    def __init__(self):
        self.state='start'
        self.sign=1
        self.ans=0
        self.active=True
        self.table={
            'start':['start','signed','number','end'],
            'signed':['end','end','number','end'],
            'in_number':['end','end','number','end'],
            'end':['end','end','end','end']
        }

    def get_col(self,c):
        if c.isspace():
            return 0
        if c=='+' or c=='-':
            return 1
        if c.isdigit():
            return 2
        return 3

    def get(self,c):
        self.state=self.table[self.state][self.get_col(c)]
        if self.state=='number':
            self.ans=self.ans*10+int(c)
            self.ans=min(self.ans,INI_MAX) if self.sign==1 else min(self.ans,-INT_MIN)
            if self.sign==1 and self.ans == INI_MAX or self.sign==-1 and self.ans==-INT_MIN:
                self.active=False
        elif self.state=='signed':
            self.sign=1 if c=='+' else -1
        elif self.state=='end':
            self.active=False


class Solution:
    def myAtoi(self, str: str) -> int:
        automaton=Automaton()
        for c in str:
            if not automaton.active:
                break
            automaton.get(c)
        return automaton.sign*automaton.ans

            
            
# @lc code=end

