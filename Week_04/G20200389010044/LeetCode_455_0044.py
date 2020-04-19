# 1. 排序后对应分配
#   只要求输出满足孩子数量
#   将孩子胃口数组排序 
#   将饼干数组排序
#   小饼干先满足小胃口的孩子
#   O(m * n)

# 2. 双指针替代二重循环
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        # g.sort()    # 胃口值排序
        # s.sort()    # 饼干尺寸排序
        # count = 0
        # for cookie in s:
        #     for i in range(len(g)):
        #         if g[i] != -1 and g[i] <= cookie:
        #             count += 1
        #             g[i] = -1
        #             break
        # return count
        
        # method 2
        # g.sort()    # 孩子胃口排序
        # s.sort()    # 饼干尺寸排序
        # count = 0
        # i = j = 0
        # while i < len(g) and j < len(s):
        #     if g[i] <= s[j]: # 饼干可给
        #         count += 1
        #         j += 1  # 指针移动，准备尝试分配下一块饼干
        #         i += 1 # 匹配下一个孩子
        #     else:
        #         # 说明当前的饼干尺寸太小，连目前最小胃口的孩子都没法满足
        #         # 孩子胃口是从小到大的，所以直接放弃分配当前饼干
        #         j += 1
        # return count
        
        
        # Sort Lists
        g.sort()
        s.sort()
		
        # List lengths
        g_length = len(g)
        s_length = len(s)
        
		# Check if either list is empty
        if (g_length == 0 or s_length == 0):
            return 0
        
		# indexes and counters
        i = s_length - 1
        j = g_length - 1
        satisfied_children = 0
        while ( i >= 0 and j >= 0 ):
            if s[i] >= g[j]:
                satisfied_children += 1
                i -= 1
                j -= 1
            elif s[i] < g[j]:
                j -= 1
                
        return satisfied_children