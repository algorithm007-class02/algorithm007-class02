package com.algorithm;

public class LeetCode_26_0100 {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int indexSlower = 0;
        for(int indexFaster = 1; indexFaster < nums.length; indexFaster++) {
            if(nums[indexFaster] != nums[indexSlower]) {
                indexSlower++;
                nums[indexSlower] = nums[indexFaster];
            }
        }

        return indexSlower + 1;
    }

}
