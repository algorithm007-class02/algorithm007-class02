# 回溯法
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        if nums == []:
            return [[]]
        res = []

        def helper(tmp, cur):
            if len(cur) == len(nums) and cur not in res:
                res.append(cur[:])
            for i, num in enumerate(tmp):
                cur.append(num)
                helper(tmp[:i] + tmp[i + 1:], cur)
                cur.pop()

        helper(nums.copy(), [])
        return res
