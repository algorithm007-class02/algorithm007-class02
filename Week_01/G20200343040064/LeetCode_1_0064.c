/**
 * 1.两数之和
 * 
 * 
 * */

int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    *returnSize = 0;

    if(numsSize < 2) {
        return NULL;
    }
    for(int i=0;i<numsSize-1;i++) {
        for(int j=i+1;j<numsSize;j++) {
            if(nums[i] + nums[j] == target) {
                int *res = malloc(sizeof(int)*2);
                res[0] = i;
                res[1] = j;
                *returnSize = 2;
                return res;
            }
        }
    }
    return NULL;
}