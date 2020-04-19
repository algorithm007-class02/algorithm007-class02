from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        group = {}

        for str in strs:
            key = ''.join(sorted(str))
            items = group.setdefault(key, [])
            items.append(str)

        return list(group.values())


class Solution2:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = []
        keys = {}

        for str in strs:
            key = ''.join(sorted(str))

            if key not in keys:
                keys[key] = len(result)
                result.append([])

            result[keys[key]].append(str)

        return result


if __name__ == '__main__':
    s = Solution2()
    print(s.groupAnagrams(['eat', 'tea', 'tan', 'ate', 'nat', 'bat']))
