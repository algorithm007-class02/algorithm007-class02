/*
LeetCode
（合并两个有序链表）题目21描述：
将两个有序链表合并为一个新的有序链表并返回。
新链表是通过拼接给定的两个链表的所有节点组成的。 
*/

//如果有哨兵结点，貌似会简洁些，可题目要求也不知道给的链表有没有哨兵结点

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (l1 == NULL) return l2;//l1为空
        if (l2 == NULL) return l1;//l2为空
        if (l1 -> val > l2 -> val) swap(l1, l2);//保证l1开始结点为新链表的开始结点
        ListNode* head = l1;//设置合并后新链表的开始结点,将表l2插入l1中
        while (l1 -> next != NULL && l2 != NULL) {//当l1与l2有一个遍历结束时跳出循环
            while (l1 -> next != NULL && l1 -> next -> val <= l2 -> val) {
                l1 = l1 -> next;//l1更新
            }
            if (l1 -> next == NULL) break;
            while (l2 != NULL && l1 -> next -> val > l2 -> val) {
                ListNode* tmp = NULL;
                tmp = l2;//用tmp指向待插入结点
                l2 = l2 -> next;//l2更新
                tmp -> next = l1 -> next;//tmp插入l1后
                l1 -> next = tmp;
                l1 = tmp;
            }
        }
        if (l2 != NULL) l1 -> next = l2;//余下的l2表直接续在l1后面
        return head;
    }
};