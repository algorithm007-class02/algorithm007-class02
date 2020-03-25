#
# @lc app=leetcode.cn id=49 lang=python3
#
# [49] 字母异位词分组
#

# @lc code=start


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        import collections
        result = []
        hash1 = []
        for str in strs:
            cnt = collections.Counter(str)
            if cnt not in hash1:
                hash1.append(cnt)
                result.append([])
            result[hash1.index(cnt)].append(str)
        return result


# @lc code=end

