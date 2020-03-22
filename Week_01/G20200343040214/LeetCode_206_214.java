public class Solution206 {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null){
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
