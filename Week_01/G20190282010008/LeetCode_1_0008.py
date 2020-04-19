class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i,j=0,1
        while(j < len(nums) ):
            # print("index  of i  j({0}---{1})".format(i,j))
            if (nums[j]==nums[i]):
                j=j+1
                continue
            if (nums[j]!=nums[i]):
                i=i+1
                nums[i]=nums[j]
                j=j+1
        return (i+1)





if __name__ == "__main__":
    
    solution=Solution()
    #inputarry=[0,0,1,1,1,2,2,3,3,4]
    inputarry=[1,1,2]
    print(solution.removeDuplicates(inputarry))







