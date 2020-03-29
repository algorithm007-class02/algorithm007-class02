package Week_01.G20200343040172;

/**
 * LeetCode-24 两两交换链表中的节点
 */
public class LeetCode_24_0172 {

    /**
     * swapPairsSolution_1和swapPairsSolution_2均是通过迭代的方式来进行交换
     * swapPairsSolution_1的代码更加简洁
     *
     * @param head
     * @return
     */
    public ListNode swapPairsSolution_1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode left = head;
        ListNode right = head.next;
        while (left.next != null && right.next != null) {
            if (left == head) head = right;
            ListNode recordNext = right.next;
            left.next = right.next;
            right.next = left;
            right = recordNext.next;
            left = recordNext;
        }
        return head;
    }

    public ListNode swapPairsSolution_2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head, right = head.next, prev = head;
        while (left != null && left.next != null) {
            left.next = right.next;
            right.next = left;
            if (prev == head) head = right;
            else prev.next = right;
            prev = right.next;
            if (left == null || left.next == null) {
                return head;
            }
            right = right.next.next.next;
            left = left.next;
        }
        return head;
    }

    /**
     * 使用递归的方法
     * 递归代码来自LeetCode
     *
     *递归总结，当前代码只管交换当前的两个节点，除自身以外的节点传入下一个递归
     * @param head
     * @return
     */
    public ListNode swapPairsSolution_3(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next = swapPairsSolution_3(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }
}
