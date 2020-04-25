# 回溯法
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if nums==[]:
            return []
        res = []
        def helper(cur):
            if len(cur)==len(nums):
                res.append(cur[:])
                return
            for num in nums:
                if num in cur:
                    continue
                else:
                    cur.append(num)
                    helper(cur)
                    cur.pop()
        helper([])
        return res

