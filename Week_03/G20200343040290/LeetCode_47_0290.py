class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        leng = len(nums)
        def helper(nums,level,s):
            if level == leng:
                if not s in res:
                    res.append(s)
                return
            for i in nums:
                nums_cp = nums[:]
                nums_cp.remove(i)
                helper(nums_cp,level+1,s+[i])
        helper(nums,0,[])
        return res
