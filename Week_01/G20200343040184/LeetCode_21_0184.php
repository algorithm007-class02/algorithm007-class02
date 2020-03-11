<?php
/**
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 */
/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class Solution {

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function mergeTwoLists($l1, $l2) {
        $dummy = new ListNode(0);
        $pre = $dummy;
        while ($l1 && $l2){
            if ($l1->val < $l2->val) {
                $pre->next = $l1;
                $l1 = $l1->next;
            } else {
                $pre->next = $l2;
                $l2 = $l2->next;
            }
            $pre = $pre->next;
        }
        $pre->next = $l1 ? $l1 : $l2;
        return $dummy->next;
    }
}