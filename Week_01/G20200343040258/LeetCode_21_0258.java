/**
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//递归
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //当前 l1 节点和 L2 节点比较 指向比较小的节点
        ListNode head = new ListNode(0);
        ListNode tempNode = head;
        mergeRecur(tempNode,l1,l2);
   
        return head.next;
    }

    public void mergeRecur(ListNode tempNode,ListNode l1, ListNode l2){
         if(l1 == null){
                tempNode.next = l2;
                return;
            }

             if(l2 == null){
                tempNode.next = l1;
                return;
            }

            if( l1.val > l2.val){
                tempNode.next = l2;
                l2 = l2.next;
            }else{
                tempNode.next = l1;
                l1 = l1.next;
            }
            
            tempNode = tempNode.next;
            mergeRecur(tempNode,l1,l2);
    }

     
}
// 时间复杂度 O（n+m）
// 空间复杂度 O（n+m） 消耗系统栈

//迭代
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //当前 l1 节点和 L2 节点比较 指向比较小的节点
        ListNode head = new ListNode(0);
        ListNode tempNode = head;
        while (l1 != null || l2 != null){
            if(l1 == null){
                tempNode.next = l2;
                break;
            }

             if(l2 == null){
                tempNode.next = l1;
                break;
            }

            if( l1.val > l2.val){
                tempNode.next = l2;
                l2 = l2.next;
            }else{
                tempNode.next = l1;
                l1 = l1.next;
            }
            tempNode = tempNode.next;
        }
        return head.next;
    }

     
}
// 时间复杂度 O（n+m）
// 空间复杂度 O（1）