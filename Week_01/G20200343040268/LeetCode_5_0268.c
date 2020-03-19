int* twoSum(int* nums, int numsSize, int target, int* returnSize){

    int i = 0;
    int j = 0;
    int *retnums = (int *)malloc(2 * sizeof(int));
    for (i = 0; i < numsSize; i++){
            for (j = i + 1; j < numsSize; j++){
                if ((nums[j] + nums[i]) == target){
                    retnums[0] = i;
                    retnums[1] = j;
                    *returnSize = 2;
                    return retnums;
                }
            }

    }
    return NULL;
}
