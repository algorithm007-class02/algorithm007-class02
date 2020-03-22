/**
 * 283.移动零
 * 
 * */

void moveZeroes(int* nums, int numsSize){
    for(int left=0,i=0;i<numsSize;i++) {
        if(nums[i] != 0) {
            nums[left] = nums[i];
            if(left++ != i) {
                nums[i] = 0;
            }
        }
    }
}