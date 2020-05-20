class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        len_s, len_t = len(s), len(t)
        if len_s != len_t:
            return False

        temp_map = {}
        for sv in s:
            temp_map.setdefault(sv, 0)
            temp_map[sv] += 1

        for tv in t:
            if tv in temp_map and temp_map[tv] >= 0:
                temp_map[tv] -= 1
            else:
                return False

        for _, v in temp_map.items():
            if v != 0:
                return False

        return True