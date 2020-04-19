class Solution:
    def twoSum(self, nums, target) :
        length=len(nums)
        store_dict={}
        for i in range(length):
            finded=store_dict.get(target-nums[i])
            if finded!=None:
                return [finded,i]
            store_dict[nums[i]]=i
        return []