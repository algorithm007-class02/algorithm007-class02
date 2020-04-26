package com.wxs.algorithm1.week06;

import com.wxs.queue.ListNode;

import java.util.Stack;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-14
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_445_0316 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();


        while (l1 != null){
            stack1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }


        ListNode head = null;
        int tenDigits = 0;


        while (!stack1.isEmpty() || !stack2.isEmpty() || tenDigits!=0){

           int numL1 = stack1.isEmpty() ? 0 : stack1.pop().val;
           int numL2 = stack2.isEmpty() ? 0 : stack2.pop().val;


           int sum = numL1 + numL2 +tenDigits;

           ListNode listNode = new ListNode(sum % 10);

            tenDigits = sum / 10;

           listNode.next = head;

           head = listNode;

        }

        return head;
    }


}
