/**
 * 26.删除数组中的重复项
 * 
 * */

int removeDuplicates(int* nums, int numsSize) {
    if(numsSize < 2)
        return numsSize;
        
    int left=0;
    for(int i=1;i<numsSize;i++) {
        if(nums[left] != nums[i]) {
            nums[++left] = nums[i];
        }
    }
    return left+1;
}

