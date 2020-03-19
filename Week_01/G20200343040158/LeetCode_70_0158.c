//
//  LeetCode_70_0158.c
//  C-Test
//
//  Created by apple on 2020/3/15.
//  Copyright © 2020 apple. All rights reserved.
//

#include <stdio.h>

int climbStairs(int n){
    if (n < 0) {
        return 0;
    }
    if (n <= 2) {
        return n;
    }
    
    int f1 = 1;
    int f2 = 2;
    int f3 = 0;
    
    for (int i = 2; i < n; i++) {
        f3 = f1+f2;
        f1 = f2;
        f2 = f3;
    }
    return f3;
}
