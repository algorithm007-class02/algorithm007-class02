import java.util.ArrayList;
import java.util.List;

public class Solution142 {
    public static void main(String[] args) {

    }

    // 双指针
    public ListNode detectCycle(ListNode head) {
        // 快慢指针第一次相遇后
        if (head == null || head.next == null)
            return null;
        ListNode p1 = head;
        ListNode p2 = head;
        boolean cycle = false;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                cycle = true;
                break;
            }
        }
        p2 = head;
        if (cycle) {
            while (p2 != p1) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p2;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        // 使用 list 来暂存访问过的节点
        List<ListNode> nodes = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            if (nodes.contains(node)) {
                return node;
            }
            nodes.add(node);
            node = node.next;
        }
        return null;
    }
}
