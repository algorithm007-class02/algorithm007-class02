# 解法一:三次翻转
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) <= 1:
            return
        
        k = k%len(nums) if k>=len(nums) else k
        if k==0:
            return

        nums[0:-k] = nums[0:-k][::-1]
        nums[-k:] = nums[-k:][::-1]
        nums[:] = nums[::-1]
        return

# 解法二:循环填放
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) <= 1:
            return
        
        k = k%len(nums) if k>=len(nums) else k
        if k==0:
            return
        i = 0
        index = k
        insert = nums[0]
        flag = 0

        for i in range(len(nums)):
            tmp = nums[index]
            nums[index] = insert
            if index==flag:
                index += 1
                tmp = nums[index]
                flag += 1
            insert = tmp
            index = (index+k)%len(nums)

        return

# 解法三:栈入栈出
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums)<=1:
            return

        k = k%len(nums) if k>=len(nums) else k

        for i in range(k):
            nums.insert(0,nums[len(nums)-1])
            nums.pop(-1)
