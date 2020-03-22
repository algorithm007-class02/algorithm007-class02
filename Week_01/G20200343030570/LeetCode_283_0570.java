class Solution {
    public void moveZeroes(int[] nums) {
        int i,j,temp;
        for(i=0,j=0;i<nums.length;++i){
            if(nums[i]!=0){
                temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }

        }
    }
}