int removeDuplicates(int* nums, int numsSize){
    if (nums == NULL) return 0;
    if (numsSize == 0) return 0;

    int i = 0;
    int j = 0;
    for (i = 0; i < numsSize; i++){
        if (nums[i] != nums[j])
            nums[++j] = nums[i];
    }
    return j + 1;
}

