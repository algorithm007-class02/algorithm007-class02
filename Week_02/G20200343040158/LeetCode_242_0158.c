//
//  LeetCode_242_0158.c
//  C-Test
//
//  Created by apple on 2020/3/21.
//  Copyright © 2020 apple. All rights reserved.
//

#include <stdio.h>
#include <stdbool.h>

bool isAnagram(char * s, char * t){
    int n = strlen(s), m = strlen(t);
    if (n != m) {
        return false;
    }
    int a[26] = {};
    for (int i = 0; i < n; i++) {
        a[s[i]-'a']++;
        a[t[i]-'a']--;
    }
    for (int i = 0; i < 26; i++) {
        if (a[i]!=0) {
            return false;
        }
    }
    return true;
}
