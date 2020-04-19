# -*- coding: utf-8 -*-
# @Time    : 2020-03-21 21:54
# @Version : V 0.1
# @File    : LeetCode_49_0212.py
# @Desc    :
# 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
#
#  示例:
#
#  输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
# 输出:
# [
#   ["ate","eat","tea"],
#   ["nat","tan"],
#   ["bat"]
# ]
#
#  说明：
#
#
#  所有输入均为小写字母。
#  不考虑答案输出的顺序。
#
#  Related Topics 哈希表 字符串

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = {}
        for str in strs:
            # python 元组的不可变性
            key = tuple(sorted(str))
            if key in map:
                map[key].append(str)
            else:
                map[key] = [str]
        print(map)
        return [x for x in map.values()]

# leetcode submit region end(Prohibit modification and deletion)
