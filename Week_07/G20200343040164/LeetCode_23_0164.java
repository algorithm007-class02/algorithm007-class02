//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //分治
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return helper(lists,0,lists.length - 1);
    }
    ListNode helper(ListNode[] lists, int begin, int end) {
        if (begin == end) return lists[begin];
        int mid = begin + (end - begin) / 2;
        ListNode left = helper(lists,begin,mid);
        ListNode right = helper(lists,mid + 1,end);
        return merge(left,right);
    }
    ListNode merge(ListNode a,ListNode b) {
        if (a == null || b == null) return a == null ? b : a;
        if (a.val <= b.val) {
            a.next = merge(a.next,b);
            return a;
        } else {
            b.next = merge(a,b.next);
            return b;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**堆排序
 * public ListNode mergeKLists(ListNode[] lists) {
 *         if (lists == null || lists.length == 0) return null;
 *         PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
 *             @Override
 *             public int compare(ListNode o1, ListNode o2) {
 *                 return (o1.val - o2.val);
 *             }
 *         });
 *         ListNode dummy = new ListNode(-1);
 *         ListNode cur = dummy;
 *         for (int i = 0; i < lists.length; i++) {
 *             ListNode head = lists[i];
 *             if (head != null) queue.add(head);
 *         }
 *         while (!queue.isEmpty()) {
 *             ListNode node = queue.poll();
 *             cur.next = node;
 *             cur = cur.next;
 *             if (node.next != null)
 *                 queue.add(node.next);
 *         }
 *         cur.next = null;
 *         return dummy.next;
 *     }
 */
/**两两合并链表
 * public ListNode mergeKLists(ListNode[] lists) {
 *         if (lists == null || lists.length == 0) return null;
 *         ListNode res = lists[0];
 *         //将lists[0]作为最终合并的链表，然后将list[0]和lists[1]合并成lists[0-1]
 *         //再将lists[0-1]和lists[2]合并，如此反复最终lists[0]就是最终结果
 *         for (int i = 1; i < lists.length; i++) {
 *             res = merge(res,lists[i]);
 *         }
 *         return res;
 *     }
 *     ListNode merge(ListNode a, ListNode b) {
 *         if (a == null || b == null)
 *             return a == null ? b : a;
 *         if (a.val <= b.val) {
 *             a.next = merge(a.next,b);
 *             return a;
 *         } else {
 *             b.next = merge(a,b.next);
 *             return b;
 *         }
 *     }
 */
