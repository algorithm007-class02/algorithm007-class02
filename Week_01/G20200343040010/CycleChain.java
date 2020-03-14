package com.algorithm.firstWeek;

/**
 * 环形链表
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 */
public class CycleChain {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        System.out.println(hasCycle(head));
    }

    private static boolean hasCycle(ListNode head) {
        if(null == head || null == head.next) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast) {
            if(null == slow.next || null == fast.next) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
