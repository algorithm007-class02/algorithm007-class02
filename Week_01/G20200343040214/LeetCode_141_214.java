import java.util.List;

public class Solution141 {
    public static void main(String[] args) {

    }
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode kuai = head.next;
        ListNode man = head;
        while (kuai != man){
            if(kuai == null || kuai.next == null) return false;
            man = man.next;
            kuai = kuai.next.next;
        }
        return true;
    }
}
