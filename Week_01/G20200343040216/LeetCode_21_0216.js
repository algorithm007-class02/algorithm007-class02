/*
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 */

const mergeTwoLists = function (l1, l2) {
  let prevHead = new ListNode(-1);
  let prevNode = prevHead;
  while (l1 != null && l2 != null) {
    if (l1.val <= l2.val) {
      prevNode.next = l1;
      l1 = l1.next
    } else {
      prevNode.next = l2;
      l2 = l2.next;
    }
    prevNode = prevNode.next;
  }
  prevNode.next = l1 ? l1 : l2;
  return prevHead.next;
};
