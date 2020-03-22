//
//  LeetCode_206_0158.c
//  C-Test
//
//  Created by apple on 2020/3/15.
//  Copyright © 2020 apple. All rights reserved.
//

#include <stdio.h>

struct ListNode* reverseList(struct ListNode* head){
    if (head == NULL || head->next == NULL) {
        return head;
    }
    
    struct ListNode* p = head->next;
    head->next = NULL;
    
    while (p != NULL) {
        struct ListNode* tmp = p->next;
        p->next = head;
        head = p;
        p = tmp;
    }
    return head;
}
