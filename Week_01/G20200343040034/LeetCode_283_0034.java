class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0,j = 0;i< nums.length,i++){
            if(nums[i] != 0){
                nums[j] == nums[i];
                if(j != i){
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}