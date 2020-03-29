class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0 ; i < nums.length ; i++){
            nums[j] = nums[i];
            if(nums[i] != 0){
                if(i != j){
                    nums[i]=0;
                }
                j++;
           }
        }
    }
}