# 1. 暴力法 - O(m*n)
# 2. 哈希表 - O((n-m)log(n-m) + n)
# 3. 计数排序 - O(n)
class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        # res = []
        # for num in arr2:
        #     res += [num] * arr1.count(num)
        # rest = []
        # for num in arr1:
        #     if num not in arr2:
        #         rest.append(num)
        # return res + sorted(rest)

        # dic = {}
        # tmp = []
        # res = []
        # for num in arr1:
        #     if num in arr2:
        #         dic[num] = dic.get(num, 0) + 1
        #     else:
        #         tmp.append(num)
        # for num in arr2:
        #     res += [num] * dic[num]
        # tmp.sort()
        # return res + tmp

        count = [ 0 for _ in range(1001)]
        res = []
        for num in arr1:
            count[num] += 1
        for num in arr2:
            res += [num] * count[num]
            count[num] = 0
        for num in range(1001):
            if count[num] > 0:
                res += [num] * count[num]
        return res