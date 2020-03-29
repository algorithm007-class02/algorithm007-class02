public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
