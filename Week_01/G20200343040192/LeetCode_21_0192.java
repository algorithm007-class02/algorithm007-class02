//自己的解法
class Solution {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //判断特殊情况
    if (l1 == null && l2 == null) {
      return null;
    } else if (l1 == null && l2 != null) {
      return sortListNode(l2);
    } else if (l1 != null && l2 == null) {
      return sortListNode(l1);
    }
    //遍历短的那个链表来节省时间
    if (length(l1) < length(l2)) {
      ListNode temp = l1;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = l2;
      return sortListNode(l1);
    } else {
      ListNode temp = l2;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = l1;
      return sortListNode(l2);
    }
  }

  //获取长度的方法
  public int length(ListNode head) {
    int length = 0;
    ListNode temp = head;
    while (temp.next != null) {
      length++;
      temp = temp.next;
    }
    return length;
  }

  //冒泡排序的方法
  public ListNode sortListNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }  //链表为空或者仅有单个结点
    ListNode cur = null, tail = null;
    cur = head;
    while (cur.next != tail) {
      while (cur.next != tail) {
        if (cur.val > cur.next.val) {
          int tmp = cur.val;
          cur.val = cur.next.val;
          cur.next.val = tmp;

        }
        cur = cur.next;
      }
      tail = cur;  //下一次遍历的尾结点是当前结点(仔细琢磨一下里面的道道)
      cur = head;     //遍历起始结点重置为头结点
    }
    return head;
  }
}