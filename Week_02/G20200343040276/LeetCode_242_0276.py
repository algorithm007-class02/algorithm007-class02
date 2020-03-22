#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#

# @lc code=start
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        list_1=list(s)
        list_2=list(t)
        list_2.sort()
        list_1.sort()
        if list_1==list_2:
            return True
        else:
            return False
# @lc code=end

