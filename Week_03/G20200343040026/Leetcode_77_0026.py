# 回溯法
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if n==0 or k==0 or k>n:
            return []
        res = []
        def helper(start,cur):
            if len(cur)==k:
                res.append(cur[:])
            for num in range(start, n+1):
                cur.append(num)
                helper(num+1,cur)
                cur.pop()
        helper(1, [])
        return res
