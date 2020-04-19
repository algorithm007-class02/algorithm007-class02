package main

func main() {

}

type ListNode struct {
	Next  *ListNode
	Value int
}

func getIntersectionNode(headA *ListNode, headB *ListNode) *ListNode {
	curA, curB := headA, headB
	for curA != curB{
		if curA == nil{
			curA = headA
		}else {
			curA = curA.Next
		}
		if curB == nil{
			curB = headA
		}else {
			curB = curB.Next
		}
	}
	return curA
}
