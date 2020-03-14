class Solution {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        for(int i = 0; i < nums.length; ++i) {
            if(i % k == 0 && i + k < nums.length) {
                temp = nums[i + k];
                nums[i + k] = nums[i];
            }
        }
    }
    
}