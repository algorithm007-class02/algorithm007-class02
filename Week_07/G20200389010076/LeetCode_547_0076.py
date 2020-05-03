#
# @lc app=leetcode.cn id=547 lang=python3
#
# [547] 朋友圈
#

# @lc code=start
from typing import List
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        length=len(M)
        father=[i for i in range(length)]


        def find(cur):
            if father[cur]!=cur:
                father[cur]=find(father[cur])
            return father[cur]
        

        def union(stu_a,stu_b):
            father[find(stu_a)]=find(stu_b)


        for stu_a in range(length):
            for stu_b in range(stu_a):
                if M[stu_a][stu_b]==1:
                    union(stu_a,stu_b)

        for i in range(length):
            find(i)

        return len(set(father))
        
        
# @lc code=end



        # father=[i for i in range(len(M))]

        # def find(a):
        #     if father[a]!=a:
        #         father[a]=find(father[a])
        #     return father[a]
        
        # def union(a,b):
        #     father[find(b)]=find(a)
        
        # for a in range(len(M)):
        #     for b in range(a):
        #         if M[a][b]:
        #             union(a,b)
        # for i in range(len(M)):
        #     find(i)
        # return len(set(father))