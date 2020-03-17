package com.wxs.algorithm1;

import com.wxs.queue.ListNode;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-14
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_21_0316 {

    public static void main(String[] args) {


        mergeTwoLists(get1(), get2());


    }

    public static ListNode get1() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(4);
        one.next = two;
        two.next = three;
        return one;
    }


    public static ListNode get2() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(5);
        one.next = two;
        two.next = three;
        return one;
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(0);
        ListNode curr = listNode;

        while (l1 != null && l2 != null) {

            if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
            }

            curr = curr.next;

        }

        curr.next = l1 == null ? l2 : l1;


        return listNode.next;

    }


    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }

    }


}
