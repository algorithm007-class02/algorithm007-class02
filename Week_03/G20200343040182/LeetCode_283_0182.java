class Solution {
    public void moveZeroes(int[] nums) {

        if (nums == null) {
            return;
        }
        
        //solv1:
        // int j = 0; //j is the slower pointer that refers to non zero element
        // for (int i=0; i<nums.length; i++) {
        //     if(nums[i] != 0) {
        //         nums[j++] = nums[i];
        //     }
        // }

        // for( ; j<nums.length; j++) {
        //     nums[j] = 0;
        // }



        //solv2: swap
        int j = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }
}