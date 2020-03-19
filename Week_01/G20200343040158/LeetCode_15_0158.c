//
//  LeetCode_15_0158.c
//  C-Test
//
//  Created by apple on 2020/3/15.
//  Copyright © 2020 apple. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

int compareByIncrease(const void* a, const void* b) {
    return *(int*)a - *(int*)b;
}

int** threeSum(int* nums, int numsSize, int* returnSize, int** returnColumnSizes){
    *returnSize = 0;
    if (numsSize < 3) {
        return NULL;
    }
    
    int cur = 0;
    int low = cur+1;
    int high = numsSize-1;
    
    int **result = (int**)malloc(sizeof(int*)*(numsSize)*(numsSize));
    *returnColumnSizes = (int*)malloc(sizeof(int)*(numsSize)*(numsSize));
    qsort(nums, numsSize, sizeof(int), compareByIncrease);
    
    while (nums[cur] <= 0 && (cur + 1 < numsSize - 1)) {
        low = cur+1;
        high = numsSize-1;
        while (low < high) {
            
            if (0 == nums[cur] + nums[low] + nums[high]) {
                result[*returnSize] = (int*)malloc(sizeof(int)*3);
                (*returnColumnSizes)[*returnSize] = 3;
                result[*returnSize][0] = nums[cur];
                result[*returnSize][1] = nums[low];
                result[*returnSize][2] = nums[high];
                (*returnSize)++;
                
                while ((nums[low] == nums[++low]) && (low < high));
                while ((nums[high] == nums[--high]) && (low < high));
                
            } else if (0 < nums[cur] + nums[low] + nums[high]) {
                high--;
            } else {
                low++;
            }
        }
        while ((nums[cur] == nums[++cur]) && (cur + 1 < numsSize - 1));
    }
    return result;
}

