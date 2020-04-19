//
//  LeetCode_239_0158.c
//  C-Test
//
//  Created by apple on 2020/3/18.
//  Copyright © 2020 apple. All rights reserved.
//

#include <stdio.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* maxSlidingWindow(int* nums, int numsSize, int k, int* returnSize){
    if (nums == NULL || numsSize == 0 || k <= 0 || numsSize < k) {
        *returnSize = 0;
        return NULL;
    }
    *returnSize = numsSize-k+1;
    int start = 0, end = 0;
    int *ans = (int*)malloc(sizeof(int)*(numsSize-k+1));
    int j = 0, i = 0, maxIndex = -1;
    for (start = 0, end = k-1; end < numsSize; end++,start++) {
        if (maxIndex >= start && maxIndex <= end) {
            if (nums[end] >= nums[maxIndex]) {
                maxIndex = end;
            }
        } else {
            maxIndex = start;
            for (i = start+1; i <= end; i++) {
                if (nums[i] >= nums[maxIndex]) {
                    maxIndex = i;
                }
            }
        }
        ans[j++] = nums[maxIndex];
    }
    
    return ans;
}
