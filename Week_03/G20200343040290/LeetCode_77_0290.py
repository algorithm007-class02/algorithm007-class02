class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        n_list = [i+1 for i in range(n)]
        def helper(n_list,k,level,s):
            if level == k:
                res.append(s)
                return
            for c,i in enumerate(n_list):
                helper(n_list[c+1:],k,level+1,s+[i])

        helper(n_list,k,0,[])
        return res
