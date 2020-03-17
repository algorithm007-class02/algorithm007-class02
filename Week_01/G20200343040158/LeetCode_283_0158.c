//
// Created by apple on 2020/3/14.
//

void moveZeroes(int* nums, int numsSize){
    if (nums == NULL) {
        return;
    }

    int j = 0;
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] != 0) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j++] = t;
        }
    }
}