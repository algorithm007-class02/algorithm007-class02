/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (67.99%)
 * Likes:    838
 * Dislikes: 0
 * Total Accepted:    187.7K
 * Total Submissions: 275.9K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    * two pointers method: prev and current
    */ 
    // public static ListNode reverseList(ListNode head) {
    //     ListNode prev = null;
    //     ListNode current = head;
    //     while (current != null) {
    //       ListNode next = current.next;
    //       current.next = prev;
    //       prev = current;
    //       current = next;
    //     }
    //     return prev;
    // }

    /*
    * two pointers method: current and next
    */ 
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head.next;
        ListNode last = head;
        last.next = null;
        while (current != null) {
          ListNode next = current.next;
          current.next = last;
          last = current;
          current = next;
        }
        return last;
    }

    /*
    * recursion method
    */
    // public ListNode reverseList(ListNode head) {
    //     if (head == null || head.next == null) return head;
    //     ListNode p = reverseList(head.next);
    //     head.next.next = head;
    //     head.next = null;
    //     return p;
    // }
}
// @lc code=end

