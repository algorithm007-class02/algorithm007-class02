package week03.g20200343040172;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 每日一题 LeetCode-876 链表的中间结点
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class LeetCode_876_0172 {

    /**
     * 使用数组或者是HashMap存储节点
     *
     * @param head
     * @return
     */
    public static ListNode middleNode_1(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>(100);
        int count = 0;
        while (head != null) {
            count++;
            map.put(count, head);
            head = head.next;
        }
        return map.get(count / 2 + 1);
    }
}
