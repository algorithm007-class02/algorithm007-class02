package Week_01.G20200343040172;

import java.util.HashMap;

/**
 * LeetCode-142 环形链表 ii
 */
public class LeetCode_142_0172 {

    /**
     * 使用HashMap将遍历过程中遇到的ListNode和其对应的位置一一记录下来
     * 当在遍历过程中发现该节点已经存在于Map中，则返回其对应位置
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode, Integer> hashmap = new HashMap();
        int i = 0;
        while (head != null) {
            //TODO 如果map中已经存在了对应的key，也就是对应的node，则无法put成功，put成功则会返回null，
            // 避免了再使用containsKey()来进行查找
            if (hashmap.put(head, i) != null) {
                System.out.println("tail connects to node index " + hashmap.get(head));
                return head;
            } else {
                hashmap.put(head, i);
                head = head.next;
                i++;
            }
        }
        System.out.println("no cycle");
        return null;
    }
}
