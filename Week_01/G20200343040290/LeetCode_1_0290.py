class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_cp = nums[:]
        nums.sort()
        i,j = 0,len(nums)-1
        while i<j:
            if (nums[i] + nums[j]) > target:
                j -= 1
            elif (nums[i] + nums[j]) < target:
                i += 1
            else:
                ind1 = nums_cp.index(nums[i])
                nums_cp[ind1] = None
                ind2 = nums_cp.index(nums[j])

                return[ind1,ind2]
