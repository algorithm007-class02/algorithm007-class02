#!/usr/bin/py
# coding=utf-8
#排序数组分类
#思路：当且仅当它们的排序字符串相等时，两个字符串是字母异位词
import collections
def groupAnagrams(strs):
    ans = collections.defaultdict(list)
    for s in strs:
        ans[tuple(sorted(s))].append(s)
    return ans.values()


#当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串是字母异位词。
def groupAnagrams_1(strs):
    ans = collections.defaultdict(list)
    for s in strs:
        count = [0] * 26
        for c in s:
            count[ord(c) - ord('a')] += 1
        ans[tuple(count)].append(s)
    return ans.values()

if __name__=='__main__':
    strs=["eat", "tea", "tan", "ate", "nat", "bat"]
    ret = groupAnagrams_1(strs)
    print ret



