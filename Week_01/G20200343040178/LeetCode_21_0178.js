/*
 * @Author: mingxing.huang
 * @Date: 2020-03-13 16:51:55
 */
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
  //   // 方法一：新建链表l，遍历l1、l2
  //   let l = new ListNode();
  //   let pointer = l;
  //   while (l1 && l2) {
  //     // 用较小值新建节点
  //     let value = Math.min(l1.val, l2.val);
  //     let nextNode = new ListNode(value);
  //     pointer.next = nextNode;
  //     pointer = pointer.next;
  //     // 移动较小者到下一个节点，继续比较
  //     if (l1.val < l2.val) {
  //       l1 = l1.next;
  //     } else {
  //       l2 = l2.next;
  //     }
  //   }
  //   // while循环结束，说明有一个链表的元素比较完了，将剩下的拼接上去即可
  //   pointer.next = l1 ? l1 : l2;
  //   return l.next;

  // 方法二：递归
  if (!l1) {
    return l2;
  }
  if (!l2) {
    return l1;
  }
  if (l1.val < l2.val) {
    l1.next = mergeTwoLists(l1.next, l2);
    return l1;
  } else {
    l2.next = mergeTwoLists(l1, l2.next);
    return l2;
  }
};
