// 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

// 示例：
// 输入：1->2->4, 1->3->4
// 输出：1->1->2->3->4->4

// 直接学习了解法 并练习
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	} else if l2 == nil {
		return l1
	}

	var l3Fast *ListNode = nil  
	var l3Last *ListNode = nil  
	var newNode *ListNode = nil 

	for true {
		if l1.Val > l2.Val {
			newNode = l2
			l2 = l2.Next
		} else {
			newNode = l1
			l1 = l1.Next
		}

		if l3Last == nil {
			l3Fast = newNode
			l3Last = newNode
		} else {
			l3Last.Next = newNode
			l3Last = newNode
		}

		if l1 == nil {
			l3Last.Next = l2
			break
		} else if l2 == nil {
			l3Last.Next = l1
			break
		}
	}

	return l3Fast
}