class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        # def backtrack(first = 0):
        #     # if all integers are used up
        #     if first == n:  
        #         output.append(nums[:])
        #     for i in range(first, n):
        #         # place i-th integer first 
        #         # in the current permutation
        #         nums[first], nums[i] = nums[i], nums[first]
        #         # use next integers to complete the permutations
        #         backtrack(first + 1)
        #         # backtrack
        #         nums[first], nums[i] = nums[i], nums[first]
        
        # n = len(nums)
        # output = []
        # backtrack()
        # res = []
        # for lst in output:
        #     if lst not in res:
        #         res.append(lst)
        # return res

        # pythonic
        from itertools import permutations
        res = list(map(list, set(permutations(nums, len(nums)))))
        return res