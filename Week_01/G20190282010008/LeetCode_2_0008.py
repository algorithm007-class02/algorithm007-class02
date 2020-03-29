
class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        indexarry=[]
        i=0
        for g in range(len(nums)):
            indexarry.append(g)
        while(i<k):
            for t in range(len(indexarry)):
                indexarry[t]=indexarry[t]-1
                if indexarry[t]== -1:
                    indexarry[t]=len(nums)-1
            i=i+1
        result=[]
        for t in indexarry:
            result.append(nums[t])
        nums=result
        print(nums)
        
if __name__ == "__main__":
    solution=Solution()
    inputarry=[1,2,3,4,5,6,7]
    solution.rotate(inputarry,1)

