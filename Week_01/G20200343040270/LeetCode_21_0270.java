/**
 * 合并两个有序链表：
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {

    /**
     * 解法一：递归
     * 时间复杂度：O(n+m)
     * 空间复杂度：O(n+m)
     *
     * @param l1 有序链表
     * @param l2 有序链表
     * @return 合并后的有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 解法二：
     * 1.新建一个头结点用来返回合并后的链表
     * 2.定义指针prev，初始态指向新建的头结点
     * 3.头结点每连接一个值小的结点，则prev指针指向该结点
     * 4.当两个链表长度不一致时，最后再将长链表的剩余部分结点连接至最后即可
     * 时间复杂度：O(n+m)
     * 空间复杂度：O(1)
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return head.next;
    }
}