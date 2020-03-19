package com.leetcode.list;

/**
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class L21MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 临时头节点
        ListNode head = new ListNode();
        // 游标节点
        ListNode cursor = head;

        while (l1 != null && l2 != null) {
            // 将较小节点加入到新的链表
            if (l1.val <= l2.val) {
                cursor.next = l1;
                l1 = l1.next;
            } else {
                cursor.next = l2;
                l2 = l2.next;
            }
            cursor = cursor.next;
        }

        // 将游标节点next指向未遍历完的链表
        if (l1 != null) {
            cursor.next = l1;
        }
        if (l2 != null) {
            cursor.next = l2;
        }

        return head.next;
    }
}
