#
# @lc app=leetcode id=49 lang=python3
#
# [49] Group Anagrams
#
from typing import List
# @lc code=start


def generate_hash_key(word):
    key = [0] * 26
    for char in word:
        key[ord(char) - 97] += 1
    return tuple(key)


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram_map = {}
        for word in strs:
            key = generate_hash_key(word)
            if key in anagram_map:
                anagram_map[key].append(word)
            else:
                anagram_map[key] = [word]
        return list(anagram_map.values())
# @lc code=end
