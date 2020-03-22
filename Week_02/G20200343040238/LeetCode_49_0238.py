# -*- coding:utf-8 -*-

# 排序 + 哈希表，最后去哈希表的values


class Solution1:
    def groupAnagrams(self, strs):
        dic = {}
        for ss in strs:
            sort_s = "".join(sorted(ss))
            if sort_s in dic:
                dic[sort_s].append(ss)
            else:
                dic[sort_s] = [ss]
        res = []
        for _, v in dic.items():
            res.append(v)
        return res

