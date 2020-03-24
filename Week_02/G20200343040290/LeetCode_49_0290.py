class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dict_table = {}
        for i in strs:
            k = ''.join(sorted(i))
            try:
                dict_table[k].append(i)
            except:
                dict_table[k] = []
                dict_table[k].append(i)
        return list(dict_table.values())
