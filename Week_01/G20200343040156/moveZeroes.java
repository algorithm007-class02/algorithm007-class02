class Solution {
    public void moveZeroes(int[] nums) {
        int counts =0;
        for(int n : nums){
            if(n!=0){
                nums[counts] = n;
                counts++;
            }
        }
        while(counts<nums.length){
            nums[counts++] = 0;
        }
    }
}