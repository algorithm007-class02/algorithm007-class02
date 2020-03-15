class Solution {
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {     
            int a = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {    
                nums[j] = nums[j-1];
            }            
            nums[0] = a;
        }
    }
}