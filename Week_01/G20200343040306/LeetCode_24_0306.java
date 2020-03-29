/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (64.71%)
 * Likes:    429
 * Dislikes: 0
 * Total Accepted:    80.4K
 * Total Submissions: 124.2K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例:
 * 
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 
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
    * two pointers method:
    *    1 2 3 4 5 6 7 ...
    * ^  ^
    *    ^   ^
    */   
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
          ListNode temp = current.next;
          if (temp != null) {
            ListNode next = temp.next;
            temp.next = current;
            if (prev != null) {
              prev.next = temp;
            }
            prev = current;
            if (next == null) {
              current.next = null;
            }
            current = next;
          } else {
            if (prev != null) {
              prev.next = current;
            }
            prev = current;
            current.next = null;
            current = temp;
          }
        }
        return newHead;
      }

    /*
    * two pointers method:
    *    1 2 3 4 5 6 7 ...
    *    ^ ^
    *        ^ ^
    */
    
    // public ListNode swapPairs(ListNode head) {
    //     if (head == null || head.next == null) return head;
    //     ListNode newHead = head.next;
    //     ListNode first = head;
    //     ListNode second = head.next;
    //     while (first != null && second != null) {
    //     ListNode temp = second.next;
    //     if (temp == null) {
    //         second.next = first;
    //         first.next = null;
    //         first = temp;
    //         second = temp;
    //     } else if (temp.next == null) {
    //         second.next = first;
    //         first.next = temp;
    //         first = temp;
    //         second = temp.next;
    //     } else {
    //         second.next = first;
    //         first.next = temp.next;
    //         first = temp;
    //         second = temp.next;
    //     }
    //     }
    //     return newHead;
    // }
}
// @lc code=end

