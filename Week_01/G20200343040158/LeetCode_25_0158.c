//
//  LeetCode_25_0158.c
//  C-Test
//
//  Created by apple on 2020/3/15.
//  Copyright © 2020 apple. All rights reserved.
//

#include <stdio.h>

struct ListNode {
    int val;
    struct ListNode *next;
};

typedef struct ListNode LNode, *LiskList;

struct ListNode* reverseKGroup(struct ListNode* head, int k){
    LNode dummy;
    LiskList cur = head;
    LiskList pre = &dummy;
    LiskList abc = NULL;
    LiskList def = NULL;
    
    int count = 0;
    int length = 0;
    
    dummy.next = head;
    
    for (cur = head; cur != NULL; cur = cur->next) {
        if (0 == (++length % k)) {
            
            abc = pre->next;
            
            for (count = 1; count < k; count++) {
                def = abc->next;
                abc->next = def->next;
                def->next = pre->next;
                pre->next = def;
            }
            
            cur = abc;
            pre = cur;
        }
    }
    
    return dummy.next;
    
}
