/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
    var root = new(ListNode)
    var ln = root
    for l1 != nil && l2 != nil {
        if l1.Val > l2.Val {
            ln.Next = l2
            ln = ln.Next
            l2 = l2.Next
        } else {
            ln.Next = l1
            ln = ln.Next
            l1 = l1.Next
        }
    }

    if l1 !=nil {
        ln.Next = l1
    } else {
        ln.Next = l2
    }

    return root.Next
}
