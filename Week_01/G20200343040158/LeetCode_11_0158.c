//
//  LeetCode_11_0158.c
//  C-Test
//
//  Created by apple on 2020/3/15.
//  Copyright © 2020 apple. All rights reserved.
//

#include <stdio.h>

int maxArea(int* height, int heightSize){
    if (height == NULL) {
        return 0;
    }
    
    int head = 0;
    int rear = heightSize-1;
    int temparea = 0;
    int maxarea = 0;
    
    for (int i = 0; i < heightSize; i++) {
        temparea = (rear - head) * ( height[head] > height[rear] ? height[rear] : height[head]);
        maxarea = maxarea > temparea ? maxarea : temparea;
        
        if (height[head] < height[rear]) {
            head++;
        } else {
            rear--;
        }
    }
    return maxarea;
}
