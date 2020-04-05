class Solution:
    def jump(self, nums: List[int]) -> int:
        inde = 0
        n=0
        i=0
        
        if len(nums)==1 or not nums:
            return 0 
        while True:
            ax =nums[i]
            if nums[i]+i>=len(nums)-1:
                    
                 return n+1
            for (j,k) in enumerate(range(i,nums[i]+i+1)):         

                if nums[k]+j>ax:
                    ax =nums[k]+j
                    inde =j
                    
            
            if inde==0:
                inde =nums[i]
            i +=inde
            n +=1
            
            if i>=len(nums)-1:
                
                return n
            inde = 0
