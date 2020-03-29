#
# @lc app=leetcode id=242 lang=python3
#
# [242] Valid Anagram
#

# @lc code=start


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        char_count = {}
        if len(s) != len(t):
            return False
        for char in s:
            char_count[char] = char_count.get(char, 0) + 1
        for char in t:
            count_in_s = char_count.get(char, 0)
            if count_in_s == 0:
                return False
            elif count_in_s == 1:
                del char_count[char]
            else:
                char_count[char] -= 1

        return not char_count

# @lc code=end
