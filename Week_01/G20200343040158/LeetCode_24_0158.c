//
//  LeetCode_24_0158.c
//  C-Test
//
//  Created by apple on 2020/3/15.
//  Copyright © 2020 apple. All rights reserved.
//

#include <stdio.h>

struct ListNode* swapPairs(struct ListNode* head){
    if (head == NULL || head->next == NULL) {
        return head;
    }
    
    struct ListNode* odd = head;
    struct ListNode* even = head->next;
    head = even;
    
    odd->next = even->next;
    even->next = odd;
    odd->next = swapPairs(odd->next);
    
    return head;
}
