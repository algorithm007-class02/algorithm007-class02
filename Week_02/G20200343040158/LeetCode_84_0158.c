//
//  LeetCode_84_0158.c
//  C-Test
//
//  Created by apple on 2020/3/17.
//  Copyright © 2020 apple. All rights reserved.
//

#include <stdio.h>

int largestRectangleArea(int* heights, int heightsSize){
    int max = 0;
    int sum = 0;
    
    for (int i = 0; i < heightsSize; i++) {
        if (heights[i] != 0) {
            sum = heights[i];
            for (int j = i-1; j >= 0; j--) {
                if (heights[j] >= heights[i]) {
                    sum += heights[i];
                } else {
                    break;
                }
                if (heights[i] == heights[j]) {
                    heights[j]--;
                }
            }
            for (int k = i+1; k < heightsSize; k++) {
                if (heights[k] >= heights[i]) {
                    sum += heights[i];
                } else {
                    break;
                }
                if (heights[k] == heights[i]) {
                    heights[k]--;
                }
            }
            if (sum > max) {
                max = sum;
            }
        }
    }
    
    return max;
}
