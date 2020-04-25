//
//  LeetCode_20_0158.c
//  C-Test
//
//  Created by apple on 2020/3/15.
//  Copyright © 2020 apple. All rights reserved.
//

#include <stdio.h>
#include <stdbool.h>

bool isValid(char * s){
    if (*s == 0) {
        return true;
    }
    
    int len = strlen(s);
    
    if (len & 1) {
        return false;
    }
    
    char stack[len];
    int top = -1;
    for (int i = 0; i < len; ++i) {
        if (s[i] == '(' || s[i] == '[' || s[i] == '{') {
            stack[++top] = s[i];
        } else if (top == -1) {
            return false;
        } else if (s[i] == stack[top] + 1 || s[i] == stack[top] + 2) {
            stack[top--] = 0;
        } else {
            return false;
        }
    }
    return top == -1;
}


