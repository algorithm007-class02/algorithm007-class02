"""
字母异位词分组
"""
#
# @lc app=leetcode.cn id=49 lang=python3
#
# [49] 字母异位词分组
# # Hashmap
# 1. 将word-->str-->sorted(w)-->tuple
# 2. tuple-->dict(key)-->str
# 时间复杂度：O(n)

# @lc code=start
class Solution:
    # def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        def groupAnagrams(self, strs):
            """
            :type strs: List[str]
            :rtype: List[List[str]]
            """
            d = {}
            for w in strs:
                key = tuple(sorted(w))
                d[key] = d.get(key, []) + [w]
            return list(d.values())
# @lc code=end
