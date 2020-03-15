public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cache = new ListNode(0);
        cache.next = head;
        ListNode pre = cache;
        ListNode end = cache;
        while (end.next != null) {
            // 分段处理翻转，翻转完成后拼接在进行下一组
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode splitStart = pre.next;
            ListNode next = end.next;
            end.next = null; // 截断
            pre.next = reverseList(splitStart);
            // 拼接
            splitStart.next = next;
            pre = splitStart;
            end = pre;
        }
        return cache.next;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            // 暂存 next
            ListNode temp = curr.next;
            // 断开
            curr.next = prev;
            // 重组
            prev = curr;
            // 后移动
            curr = temp;
        }
        return prev;
    }
}
