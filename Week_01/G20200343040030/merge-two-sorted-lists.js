/**
 * Definition for singly-linked list.
 */
function ListNode(val) {
  this.val = val;
  this.next = null;
}
/**
 * 时间复杂度O(m+n) 空间复杂度O(1)
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
  let prevHead = new ListNode(-1);
  let prev = prevHead;

  //只要有一个为空，就跳出循环，把非空的直接拼在后面
  while (l1 != null && l2 != null) {
    if (l1.val <= l2.val) {
      prev.next = l1;
      l1 = l1.next;
    } else {
      prev.next = l2;
      l2 = l2.next;
    }
    prev = prev.next;
  }
  prev.next = l1 == null ? l2 : l1;
  return prevHead.next;
};
