#
# @lc app=leetcode.cn id=49 lang=python3
#
# [49] 字母异位词分组
#

# @lc code=start
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        list_of_sorted_str = []
        list_of_anagrams = []
        for str in strs:
            list_of_sorted_str.append(''.join(sorted(str)))
        d = {}
        for key,value in enumerate(list_of_sorted_str):
            if value not in d:
                d[value]=[strs[key]]
            else:
                d[value].append(strs[key])
        for key in d:
            list_of_anagrams.append(d[key])
        return list_of_anagrams

# @lc code=end

