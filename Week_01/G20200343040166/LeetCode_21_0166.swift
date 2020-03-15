/*
 * @lc app=leetcode id=21 lang=swift
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.next = nil
 *     }
 * }
 */

public class ListNode {
    public var val: Int
    public var next: ListNode?
    public init(_ val: Int) {
        self.val = val
        self.next = nil
    }
}

class Solution {
    func mergeTwoLists(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        var headListNode = ListNode(0) // 头部占位
        var current:ListNode? = headListNode
        var l1Current = l1
        var l2Current = l2
        while  (l1Current != nil || l2Current != nil) {
            if (l1Current == nil) {
                current!.next = l2Current
                break
            }
            if (l2Current == nil) {
                current!.next = l1Current
                break
            }
            let l1Value = l1Current!.val
            let l2Value = l2Current!.val
            if (l1Value < l2Value) {
                current!.next = l1Current
                l1Current = l1Current!.next
            } else {
                current!.next = l2Current
                l2Current = l2Current!.next
            }
            current = current!.next
        }
        return headListNode.next
    }
}
// @lc code=end

