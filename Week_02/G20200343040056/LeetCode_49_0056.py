class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        result = dict()
        resultArr = list()
        for s in strs:
            find = ''.join(sorted(s))
            if find not in result:
                result[find] = []
            result[find].append(s)
        for k in result:
            resultArr.append(result[k])
        return resultArr