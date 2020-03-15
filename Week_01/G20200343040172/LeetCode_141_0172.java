package Week_01.G20200343040172;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * LeetCode-141 环形链表 i
 * 思路:
 * 方法一：设置超时时间
 * 方法二：使用Map或者是Set
 * 方法三：使用快慢指针
 */
public class LeetCode_141_0172 {

    /**
     * 使用set，不断将链表中的节点存储在Set中，当无法向Set中添加某个节点的时候，则说明该节点已经存储在了Set中
     *
     * @param head
     * @return
     */
    public boolean hasCycleSolution_1(ListNode head) {
        Set<ListNode> set = new LinkedHashSet<>();
        while (head != null) {
            //TODO 当向Set中添加一个已经存在的元素，则会返回false，添加也将会不成功
            if (set.add(head) == false) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 使用快慢指针的方式，当快慢指针相遇的时候则说明有环
     *
     * @param head
     * @return
     */
    public boolean hasCycleSolution_2(ListNode head) {
        ListNode slow, fast;
        if (head == null || head.next == null) {
            return false;
        }
        slow = head;
        fast = head.next.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
