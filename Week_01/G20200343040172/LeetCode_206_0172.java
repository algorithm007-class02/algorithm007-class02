package Week_01.G20200343040172;

/**
 * LeetCode-206 反转链表
 */

public class LeetCode_206_0172 {

    /**
     * 使用迭代的方法，依次进行交换
     *
     * @param head
     * @return
     */
    public ListNode reverseListSolution1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode flag = null, prev = head, last = head.next;
        while (prev.next != null) {
            prev.next = flag;
            flag = prev;
            prev = last;
            last = last.next;
        }
        prev.next = flag;
        return prev;
    }

    /**
     * 使用递归
     * 递归的代码参见官方解题，使用递归的好处就是在于代码简洁，弊端就是时间空间复杂度过高，而且也不太容易理解
     *
     * @param head
     * @return
     */
    public static ListNode reverseListSolution2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListSolution2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}




