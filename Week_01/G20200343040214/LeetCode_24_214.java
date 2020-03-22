public class Solution24 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(swapPairs(node1));
    }
    public static ListNode swapPairs(ListNode head) {
        ListNode cache = head;
        while (head != null && head.next != null){
            ListNode c1 = head;
            ListNode c2 = head.next;
            int temp = c1.val;
            c1.val = c2.val;
            c2.val =temp;
            head = head.next.next;
        }
        return cache;
    }
}
