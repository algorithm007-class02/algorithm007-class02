/**
 * 21. 合并两个有序链表
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
https://leetcode-cn.com/problems/merge-two-sorted-lists/

解答：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/yi-kan-jiu-hui-yi-xie-jiu-fei-xiang-jie-di-gui-by-/
*/

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            int value = 0;
            if (l1.val > l2.val) {
                value = l2.val;
                l2 = l2.next;
            } else {
                value = l1.val;
                l1 = l1.next;
            }
            ListNode node = new ListNode(value);
            node.next = null;
            tail.next = node;
            tail = node;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return head.next;
    }

    // 递归解法：一看就会，一写就废
    /**
     * 
     *   class Solution {
     *       public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     *           if (l1 == null) {
     *               return l2;
     *           }
     *           else if (l2 == null) {
     *               return l1;
     *           }
     *           else if (l1.val < l2.val) {
     *               l1.next = mergeTwoLists(l1.next, l2);
     *               return l1;
     *           }
     *           else {
     *               l2.next = mergeTwoLists(l1, l2.next);
     *               return l2;
     *           }
     *
     *       }
     *   }
     *
     *   作者：z1m
     *   链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/yi-kan-jiu-hui-yi-xie-jiu-fei-xiang-jie-di-gui-by-/
     *   来源：力扣（LeetCode）
     *   著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    
}
